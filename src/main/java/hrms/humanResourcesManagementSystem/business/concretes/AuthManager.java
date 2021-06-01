package hrms.humanResourcesManagementSystem.business.concretes;

import java.rmi.RemoteException;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.humanResourcesManagementSystem.business.abstracts.AuthService;
import hrms.humanResourcesManagementSystem.business.abstracts.EmailService;
import hrms.humanResourcesManagementSystem.business.abstracts.EmployerService;
import hrms.humanResourcesManagementSystem.business.abstracts.JobSeekerService;
import hrms.humanResourcesManagementSystem.business.abstracts.SystemPersonnelConfirmOfEmployerService;
import hrms.humanResourcesManagementSystem.business.abstracts.VerificationCodeService;
import hrms.humanResourcesManagementSystem.core.RandomStringGenerator;
import hrms.humanResourcesManagementSystem.core.utilities.results.ErrorResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessResult;
import hrms.humanResourcesManagementSystem.entities.concretes.Employer;
import hrms.humanResourcesManagementSystem.entities.concretes.JobSeeker;
import hrms.humanResourcesManagementSystem.entities.concretes.SystemPersonnelConfirmOfEmployer;
import hrms.humanResourcesManagementSystem.entities.concretes.VerificationCode;

@Service
public class AuthManager implements AuthService{

	private JobSeekerService jobSeekerService;
	private EmployerService employerService;
	private VerificationCodeService verificationCodeService;
	private SystemPersonnelConfirmOfEmployerService systemPersonnelConfirmOfEmployerService;
	private EmailService emailLogger;
	
	@Autowired
	public AuthManager(JobSeekerService jobSeekerService, EmployerService employerService,
			VerificationCodeService verificationCodeService,
			SystemPersonnelConfirmOfEmployerService systemPersonnelConfirmOfEmployerService, EmailService emailLogger) {
		super();
		this.jobSeekerService = jobSeekerService;
		this.employerService = employerService;
		this.verificationCodeService = verificationCodeService;
		this.systemPersonnelConfirmOfEmployerService = systemPersonnelConfirmOfEmployerService;
		this.emailLogger = emailLogger;
	}
	
	
	@Override
	public Result registerJobSeeker(JobSeeker jobSeeker) throws RemoteException {
		
		Result result = this.jobSeekerService.add(jobSeeker);
		
		if (!result.isSuccess()) {
			return result;
		}
		
		String vCode = RandomStringGenerator.getRandomAlphaNumericString();
		while(this.checkIfVerificationCodeExists(vCode)) {
			vCode = RandomStringGenerator.getRandomAlphaNumericString();
		}
		
		VerificationCode verificationCode = new VerificationCode();
		verificationCode.setCode(vCode);
		verificationCode.setUserId(jobSeeker.getId());
		
		this.verificationCodeService.add(verificationCode);
		
		this.emailLogger.sendSimpleMessage(jobSeeker.getEmailAddress(), "Job Seeker Registration Notice",
				"Sisteme başarılı bir şekilde kayıt oldunuz! Hesabınızı aktifleştirmek için kodunuz: "
		+ verificationCode.getCode());
		
		
		return new SuccessResult("Sisteme kaydınız gerçekleşti, hesabınızın aktifleştirilmesi için,"
				+ " e-postanı adresinize gelen doğrulama kodunu girin");
		
	}
	
	@Override
	public Result registerEmployer(Employer employer) throws RemoteException {
		
		Result result = this.employerService.add(employer);
		
		if (!result.isSuccess()) {
			return result;
		}
		
		String vCode = RandomStringGenerator.getRandomAlphaNumericString();
		while(this.checkIfVerificationCodeExists(vCode)) {
			vCode = RandomStringGenerator.getRandomAlphaNumericString();
		}
		
		VerificationCode verificationCode = new VerificationCode();
		verificationCode.setCode(vCode);
		verificationCode.setUserId(employer.getId());
		
		this.verificationCodeService.add(verificationCode);
		
		String s = (employer.getEmailAddress().isBlank()) ? "kenan@kenanatasoy.com" : employer.getEmailAddress();
		
		employer.setEmailAddress(s);
		
		this.emailLogger.sendSimpleMessage(employer.getEmailAddress(), "Employer Registration Notice", 
				"İşveren olarak sisteme başarıyla kaydoldunuz, şimdi bu doğrulama kodunu girerek hesabınızı doğrulayabilirsiniz: "
				+ vCode + "\nBu kodu girdikten sonra bir sistem personelinin de hesabınızı doğrulaması gerekiyor"
						+ " ardından işveren olarak hesabınız aktifleştirilmiş olur." );
		
		return new SuccessResult();
	}

	@Override
	public Result login(String email, String password) {
		return null;
	}

	@Override
	public Result verifyJobSeeker(String userVCode, int jobSeekerId) {
		
		VerificationCode verificationCode = this.verificationCodeService
				.getByUserId(jobSeekerId).getData();
		
		JobSeeker jobSeeker = this.jobSeekerService.get(jobSeekerId).getData();
		
		if (!verificationCode.getCode().equals(userVCode)) {
			return new ErrorResult("Girdiğiniz aktivasyon kodu doğru değil");
		}
		
		if (LocalDateTime.now().isAfter(verificationCode.getExpirationDateTime())) {
			return new ErrorResult("Girdiğiniz aktivasyon kodunun tarihi geçmiş");
		}
		
		if (verificationCode.isVerified() == true) {
			return new ErrorResult("Aktivasyon kodu zaten girilmiş, hesap zaten aktifleştirilmiş");
		}
		
		else {
			verificationCode.setUserId(jobSeekerId);
			verificationCode.setVerified(true);
			verificationCode.setConfirmDateTime(LocalDateTime.now());
			this.verificationCodeService.add(verificationCode);
			this.emailLogger.sendSimpleMessage(jobSeeker.getEmailAddress(), "Email Verification for Job Seeker Notice",
					"Girdiğiniz aktivasyon kodu doğru, hesabınız başarıyla aktifleştirildi.");
			return new SuccessResult("Girdiğiniz aktivasyon kodu doğru, hesabınız başarıyla aktifleştirildi.");
		}
		
		
	}
	
	@Override
	public Result verifyEmployer(String userVCode, int employerId) {
		
		VerificationCode verificationCode = this.verificationCodeService
				.getByUserId(employerId).getData();
		
		Employer employer = this.employerService.get(employerId).getData();
		
		if (!verificationCode.getCode().equals(userVCode)) {
			return new ErrorResult("Girdiğiniz aktivasyon kodu doğru değil");
		}
		
		if (LocalDateTime.now().isAfter(verificationCode.getExpirationDateTime())) {
			return new ErrorResult("Girdiğiniz aktivasyon kodunun tarihi geçmiş");
		}
		
		if (verificationCode.isVerified() == true) {
			return new ErrorResult("Aktivasyon kodu zaten girilmiş, hesap zaten aktifleştirilmiş");
		}
		
		else {
			verificationCode.setUserId(employerId);
			verificationCode.setVerified(true);
			verificationCode.setConfirmDateTime(LocalDateTime.now());
			this.verificationCodeService.add(verificationCode);
			this.emailLogger.sendSimpleMessage(employer.getEmailAddress(), "Email Verification for Employer Notice",
					"Girdiğiniz aktivasyon kodu doğru, hesabınız doğrulandı. Şimdi hesabınızın "
					+ "tamamen aktifleştirilmesi için bir sistem personelinin sizi hesabınızı doğrulaması lazım");
			return new SuccessResult("Girdiğiniz aktivasyon kodu doğru, hesabınız başarıyla aktifleştirildi.");
		}
	}
	

	@Override
	public Result confirmEmployer(int systemPersonnelId, int employerId) {
		
		VerificationCode verificationCode = this.verificationCodeService
				.getByUserId(employerId).getData();
		
		if (!verificationCode.isVerified()) {
			return new ErrorResult("İşverenin mail doğrulaması henüz gerçekleşmemiş.");
		}
		
		Employer employer = this.employerService.get(employerId).getData();
		
		SystemPersonnelConfirmOfEmployer systemPersonnelConfirmOfEmployer = new SystemPersonnelConfirmOfEmployer();
		systemPersonnelConfirmOfEmployer.setSystemPersonnelId(systemPersonnelId);
		systemPersonnelConfirmOfEmployer.setDidConfirm(true);
		systemPersonnelConfirmOfEmployer.setConfirmDateTime(LocalDateTime.now());
		systemPersonnelConfirmOfEmployer.setEmployerId(employerId);
		this.systemPersonnelConfirmOfEmployerService.add(systemPersonnelConfirmOfEmployer);
		this.emailLogger.sendSimpleMessage(employer.getEmailAddress(), "System Personnel Confirmation of Employer Notice", 
				"Hesabınız sistem personeli tarafından doğrulandı. İşveren olarak hesabınız tamamen aktifleştirildi.");
		return new SuccessResult("İşverennin sistem personeli tarafından doğrulaması tamamlandı, hesabı"
				+ " tamamen aktifleştirildi.");
	}

	
	
	
	
	

	
	private boolean checkIfVerificationCodeExists(String vCode) {
		boolean isVerificationCodeExists = this.verificationCodeService.getAll().getData().stream()
				.filter(vC -> vC.getCode().equals(vCode))
				.findFirst().isPresent();
		return isVerificationCodeExists;
	}

}
