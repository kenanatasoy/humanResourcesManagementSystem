package hrms.humanResourcesManagementSystem.business.concretes;

import java.rmi.RemoteException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import hrms.humanResourcesManagementSystem.business.abstracts.JobSeekerService;
import hrms.humanResourcesManagementSystem.business.abstracts.UserService;
import hrms.humanResourcesManagementSystem.business.abstracts.UserValidationService;
import hrms.humanResourcesManagementSystem.core.utilities.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.ErrorResult;
import hrms.humanResourcesManagementSystem.core.utilities.Result;
import hrms.humanResourcesManagementSystem.core.utilities.SuccessDataResult;
import hrms.humanResourcesManagementSystem.core.utilities.SuccessResult;
import hrms.humanResourcesManagementSystem.dataAccess.abstracts.JobSeekerDao;
import hrms.humanResourcesManagementSystem.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService{
	
	private JobSeekerDao jobSeekerDao;
	private UserValidationService<JobSeeker> mernisServiceAdapter;
	private UserValidationService<JobSeeker> jobSeekerValidator;
	private UserService userService;
	
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao,
			@Qualifier("MernisV") UserValidationService<JobSeeker> mernisServiceAdapter,
			@Qualifier("JobSeekerV") UserValidationService<JobSeeker> jobSeekerValidator,
			UserService userService) {
		
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.mernisServiceAdapter = mernisServiceAdapter;
		this.jobSeekerValidator = jobSeekerValidator;
		this.userService = userService;
	}

	

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll());
	}

	@Override
	public DataResult<JobSeeker> get(int id) {
		return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.getOne(id));
	}

	@Override
	public Result add(JobSeeker jobSeeker) throws RemoteException {
		
		
		if(!jobSeekerValidator.validate(jobSeeker).isSuccess()) {	
			return new ErrorResult("İş arayanın isim, soyisim, e-posta adresi, şifre, doğum tarihi ve kimlik numarası zorunludur.");
		}
		
		else if(!mernisServiceAdapter.validate(jobSeeker).isSuccess()) {
			return new ErrorResult("Sadece TC vatandaşları sisteme kayıt olabilir, kimlik bilgilerinizi kontrol edin"); 
		}
		
		else if (this.checkIfEmailAddressExists(jobSeeker.getEmailAddress())) {
			return new ErrorResult("Bu email adresiyle bir hesap daha önce kayıt olmuş");
		}
		
		else if(this.checkIfNationalIdNoExists(jobSeeker)) {
			return new ErrorResult("Bu TC kimlik numarasına sahip bir hesap hâlihazırda mevcut");
		}
		
		this.jobSeekerDao.saveAndFlush(jobSeeker);
		
		return new SuccessResult();

	}

	

	@Override
	public Result update(JobSeeker jobSeeker) {
		return new SuccessResult();
	}

	@Override
	public Result delete(JobSeeker jobSeeker) {
		return new SuccessResult();
	}

	

	
	

	
	
	
	
	private boolean checkIfEmailAddressExists(String emailAddress) {
		boolean isEmailAddressExists = this.userService.getAll().getData().stream()
				.filter(u -> u.getEmailAddress().equals(emailAddress))
				.findFirst().isPresent();
		return isEmailAddressExists;
	}

	private boolean checkIfNationalIdNoExists(JobSeeker jobSeeker) {
		boolean isNationalIdNoExists = this.jobSeekerDao.findAll().stream()
				.filter(jS -> jS.getNationalIdNo().equals(jobSeeker.getNationalIdNo()))
				.findFirst().isPresent();
		return isNationalIdNoExists;
	}
	
	
}
