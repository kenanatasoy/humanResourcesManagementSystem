package hrms.humanResourcesManagementSystem.business.concretes;

import java.rmi.RemoteException;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.humanResourcesManagementSystem.business.abstracts.AuthService;
import hrms.humanResourcesManagementSystem.business.abstracts.EmailService;
import hrms.humanResourcesManagementSystem.business.abstracts.EmployerService;
import hrms.humanResourcesManagementSystem.business.abstracts.JobAdvertService;
import hrms.humanResourcesManagementSystem.business.abstracts.JobSeekerService;
import hrms.humanResourcesManagementSystem.business.abstracts.SystemPersonnelConfirmOfEmployerService;
import hrms.humanResourcesManagementSystem.business.abstracts.SystemPersonnelConfirmOfJobAdvertService;
import hrms.humanResourcesManagementSystem.business.abstracts.SystemPersonnelService;
import hrms.humanResourcesManagementSystem.business.abstracts.VerificationCodeService;
import hrms.humanResourcesManagementSystem.core.RandomStringGenerator;
import hrms.humanResourcesManagementSystem.core.utilities.results.ErrorResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessResult;
import hrms.humanResourcesManagementSystem.entities.concretes.Employer;
import hrms.humanResourcesManagementSystem.entities.concretes.JobAdvert;
import hrms.humanResourcesManagementSystem.entities.concretes.JobSeeker;
import hrms.humanResourcesManagementSystem.entities.concretes.SystemPersonnel;
import hrms.humanResourcesManagementSystem.entities.concretes.SystemPersonnelConfirmOfEmployer;
import hrms.humanResourcesManagementSystem.entities.concretes.SystemPersonnelConfirmOfJobAdvert;
import hrms.humanResourcesManagementSystem.entities.concretes.VerificationCode;

@Service
public class AuthManager implements AuthService {

	private JobSeekerService jobSeekerService;
	private EmployerService employerService;
	private VerificationCodeService verificationCodeService;
	private SystemPersonnelConfirmOfEmployerService systemPersonnelConfirmOfEmployerService;
	private EmailService emailLogger;
	private SystemPersonnelConfirmOfJobAdvertService systemPersonnelConfirmOfJobAdvertService;
	private JobAdvertService jobAdvertService;
	private SystemPersonnelService systemPersonnelService;

	@Autowired
	public AuthManager(JobSeekerService jobSeekerService, EmployerService employerService,
			VerificationCodeService verificationCodeService,
			SystemPersonnelConfirmOfEmployerService systemPersonnelConfirmOfEmployerService,
			EmailService emailLogger, SystemPersonnelConfirmOfJobAdvertService systemPersonnelConfirmOfJobAdvertService,
			JobAdvertService jobAdvertService, SystemPersonnelService systemPersonnelService) {
		super();
		this.jobSeekerService = jobSeekerService;
		this.employerService = employerService;
		this.verificationCodeService = verificationCodeService;
		this.systemPersonnelConfirmOfEmployerService = systemPersonnelConfirmOfEmployerService;
		this.emailLogger = emailLogger;
		this.systemPersonnelConfirmOfJobAdvertService = systemPersonnelConfirmOfJobAdvertService;
		this.jobAdvertService = jobAdvertService;
		this.systemPersonnelService = systemPersonnelService;
	}

	@Override
	public Result registerJobSeeker(JobSeeker jobSeeker) throws RemoteException {

		Result result = this.jobSeekerService.add(jobSeeker);

		if (!result.isSuccess()) {
			return result;
		}

		String vCode = RandomStringGenerator.getRandomAlphaNumericString();
		while (this.checkIfVerificationCodeExists(vCode)) {
			vCode = RandomStringGenerator.getRandomAlphaNumericString();
		}

		VerificationCode verificationCode = new VerificationCode();
		verificationCode.setCode(vCode);
		verificationCode.setUserId(jobSeeker.getId());

		this.verificationCodeService.add(verificationCode);

		this.emailLogger.sendSimpleMessage(jobSeeker.getEmailAddress(), "Job Seeker Registration Notice",
				"Sisteme ba??ar??l?? bir ??ekilde kay??t oldunuz! Hesab??n??z?? aktifle??tirmek i??in kodunuz: "
						+ verificationCode.getCode());

		return new SuccessResult("Sisteme kayd??n??z ger??ekle??ti, hesab??n??z??n aktifle??tirilmesi i??in,"
				+ " e-postan?? adresinize gelen do??rulama kodunu girin");

	}

	@Override
	public Result registerEmployer(Employer employer) throws RemoteException {

		Result result = this.employerService.add(employer);

		if (!result.isSuccess()) {
			return result;
		}

		String vCode = RandomStringGenerator.getRandomAlphaNumericString();
		while (this.checkIfVerificationCodeExists(vCode)) {
			vCode = RandomStringGenerator.getRandomAlphaNumericString();
		}

		VerificationCode verificationCode = new VerificationCode();
		verificationCode.setCode(vCode);
		verificationCode.setUserId(employer.getId());

		this.verificationCodeService.add(verificationCode);

		String s = (employer.getEmailAddress().isBlank()) ? "kenan@kenanatasoy.com" : employer.getEmailAddress();

		employer.setEmailAddress(s);

		this.emailLogger.sendSimpleMessage(employer.getEmailAddress(), "Employer Registration Notice",
				"????veren olarak sisteme ba??ar??yla kaydoldunuz, ??imdi bu do??rulama kodunu girerek hesab??n??z?? do??rulayabilirsiniz: "
						+ vCode
						+ "\nBu kodu girdikten sonra bir sistem personelinin de hesab??n??z?? do??rulamas?? gerekiyor"
						+ " ard??ndan i??veren olarak hesab??n??z aktifle??tirilmi?? olur.");

		return new SuccessResult();
	}

	@Override
	public Result login(String email, String password) {
		return null;
	}

	@Override
	public Result verifyJobSeeker(String userVCode, int jobSeekerId) {

		VerificationCode verificationCode = this.verificationCodeService.getByUserId(jobSeekerId).getData();

		JobSeeker jobSeeker = this.jobSeekerService.get(jobSeekerId).getData();

		if (!verificationCode.getCode().equals(userVCode)) {
			return new ErrorResult("Girdi??iniz aktivasyon kodu do??ru de??il");
		}

		if (LocalDateTime.now().isAfter(verificationCode.getExpirationDateTime())) {
			return new ErrorResult("Girdi??iniz aktivasyon kodunun tarihi ge??mi??");
		}

		if (verificationCode.getIsVerified() == true) {
			return new ErrorResult("Aktivasyon kodu zaten girilmi??, hesap zaten aktifle??tirilmi??");
		}

		else {
			verificationCode.setUserId(jobSeekerId);
			verificationCode.setIsVerified(true);
			verificationCode.setConfirmDateTime(LocalDateTime.now());
			this.verificationCodeService.add(verificationCode);
			this.emailLogger.sendSimpleMessage(jobSeeker.getEmailAddress(), "Email Verification for Job Seeker Notice",
					"Girdi??iniz aktivasyon kodu do??ru, hesab??n??z ba??ar??yla aktifle??tirildi.");
			return new SuccessResult("Girdi??iniz aktivasyon kodu do??ru, hesab??n??z ba??ar??yla aktifle??tirildi.");
		}

	}

	@Override
	public Result verifyEmployer(String userVCode, int employerId) {

		VerificationCode verificationCode = this.verificationCodeService.getByUserId(employerId).getData();

		Employer employer = this.employerService.get(employerId).getData();

		if (!verificationCode.getCode().equals(userVCode)) {
			return new ErrorResult("Girdi??iniz aktivasyon kodu do??ru de??il");
		}

		if (LocalDateTime.now().isAfter(verificationCode.getExpirationDateTime())) {
			return new ErrorResult("Girdi??iniz aktivasyon kodunun tarihi ge??mi??");
		}

		if (verificationCode.getIsVerified() == true) {
			return new ErrorResult("Aktivasyon kodu zaten girilmi??, hesap zaten aktifle??tirilmi??");
		}

		else {

			SystemPersonnelConfirmOfEmployer systemPersonnelConfirmOfEmployer = new SystemPersonnelConfirmOfEmployer();
			systemPersonnelConfirmOfEmployer.setDidConfirm(false);
			systemPersonnelConfirmOfEmployer.setEmployerId(employerId);
			this.systemPersonnelConfirmOfEmployerService.add(systemPersonnelConfirmOfEmployer);

			verificationCode.setUserId(employerId);
			verificationCode.setIsVerified(true);
			verificationCode.setConfirmDateTime(LocalDateTime.now());
			this.verificationCodeService.add(verificationCode);
			this.emailLogger.sendSimpleMessage(employer.getEmailAddress(), "Email Verification for Employer Notice",
					"Girdi??iniz aktivasyon kodu do??ru, hesab??n??z do??ruland??. ??imdi hesab??n??z??n "
							+ "tamamen aktifle??tirilmesi i??in bir sistem personelinin hesab??n??z?? do??rulamas?? laz??m");
			return new SuccessResult("Girdi??iniz aktivasyon kodu do??ru, hesab??n??z ba??ar??yla aktifle??tirildi.");
		}
	}

	@Override
	public Result systemPersonnelConfirmOfEmployer(int systemPersonnelId, int employerId) {

		VerificationCode verificationCode = this.verificationCodeService.getByUserId(employerId).getData();

		if (!verificationCode.getIsVerified()) {
			return new ErrorResult("????verenin mail do??rulamas?? hen??z ger??ekle??memi??.");
		}

		// systemPersonnelId ve/veya employerId oldu da null gelirse neler olucak
		
		Employer employer = this.employerService.get(employerId).getData();

		SystemPersonnelConfirmOfEmployer systemPersonnelConfirmOfEmployer = this.systemPersonnelConfirmOfEmployerService
				.findByEmployerId(employerId).getData();
		systemPersonnelConfirmOfEmployer.setSystemPersonnelId(systemPersonnelId);
		systemPersonnelConfirmOfEmployer.setDidConfirm(true);
		systemPersonnelConfirmOfEmployer.setConfirmDateTime(LocalDateTime.now());
		this.systemPersonnelConfirmOfEmployerService.add(systemPersonnelConfirmOfEmployer);

		this.emailLogger.sendSimpleMessage(employer.getEmailAddress(),
				"System Personnel Confirmation of Employer Notice",
				"Hesab??n??z sistem personeli taraf??ndan do??ruland??. ????veren olarak hesab??n??z tamamen aktifle??tirildi.");
		return new SuccessResult(
				"????verennin sistem personeli taraf??ndan do??rulamas?? tamamland??, hesab??" + " tamamen aktifle??tirildi.");
	}

	@Override
	public Result systemPersonnelConfirmOfJobAdvert(int systemPersonnelId, int jobAdvertId) {

		SystemPersonnelConfirmOfJobAdvert systemPersonnelConfirmOfJobAdvert = this.systemPersonnelConfirmOfJobAdvertService
				.findByJobAdvertId(jobAdvertId).getData();
		
		JobAdvert jobAdvert = this.jobAdvertService.get(jobAdvertId).getData();
		Employer employer = this.employerService.get(jobAdvert.getEmployer().getId()).getData();
		
		SystemPersonnelConfirmOfEmployer systemPersonnelConfirmOfEmployer = this
				.systemPersonnelConfirmOfEmployerService.findByEmployerId(employer.getId()).getData();
		
		SystemPersonnel systemPersonnelForJobAdvertConfirm = this.systemPersonnelService.get(systemPersonnelId).getData();
		
		if (!systemPersonnelConfirmOfEmployer.getDidConfirm()) {
			this.emailLogger.sendSimpleMessage(systemPersonnelForJobAdvertConfirm.getEmailAddress(), "Job Advert Confirmation Error Notice",
					"???? verenin i?? ilan?? hen??z onaylanamaz. ??nce i?? vereni sistem personeli olarak onaylaman??z gerekiyor.");
			return new ErrorResult("???? verenin do??rulamas??n?? ger??ekle??tirilmeden, i?? ilan??n?? onaylayamaz");
		}
		
		// systemPersonnelId ve/veya jobAdvertId oldu da null gelirse neler olucak
		
		
		systemPersonnelConfirmOfJobAdvert.setSystemPersonnelId(systemPersonnelId);
		systemPersonnelConfirmOfJobAdvert.setDidConfirm(true);
		systemPersonnelConfirmOfJobAdvert.setConfirmDateTime(LocalDateTime.now());

		jobAdvert.setPublishedDateTime(LocalDateTime.now());
		
		this.systemPersonnelConfirmOfJobAdvertService.add(systemPersonnelConfirmOfJobAdvert);

		this.emailLogger.sendSimpleMessage(employer.getEmailAddress(), "Job Advert Publishing Notice",
				"???? ilan??n??z sistem personeli taraf??ndan onaylanarak yay??na ge??mi??tir!");
		this.emailLogger.sendSimpleMessage(systemPersonnelForJobAdvertConfirm.getEmailAddress(), "Job Advert Publishing Notice",
				"???? ilan??n?? ba??ar??yla onaylad??n??z ve onaylad??????n??z i?? ilan?? yay??na ge??ti!");
		
		return new SuccessResult("???? ilan?? sistem personeli taraf??ndan do??ruland??");
	}
	
	
	
	
	
	
	
	
	private boolean checkIfVerificationCodeExists(String vCode) {
		boolean isVerificationCodeExists = this.verificationCodeService.getAll().getData().stream()
				.filter(vC -> vC.getCode().equals(vCode)).findFirst().isPresent();
		return isVerificationCodeExists;
	}

}
