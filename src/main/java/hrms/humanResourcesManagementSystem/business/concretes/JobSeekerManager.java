package hrms.humanResourcesManagementSystem.business.concretes;

import java.rmi.RemoteException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import hrms.humanResourcesManagementSystem.business.abstracts.JobSeekerService;
import hrms.humanResourcesManagementSystem.business.abstracts.UserValidationService;
import hrms.humanResourcesManagementSystem.business.validationRules.JobSeekerValidator;
import hrms.humanResourcesManagementSystem.core.MernisServiceAdapter;
import hrms.humanResourcesManagementSystem.dataAccess.abstracts.JobSeekerDao;
import hrms.humanResourcesManagementSystem.entities.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService{

	
	private JobSeekerDao jobSeekerDao;
	
	private UserValidationService<JobSeeker> mernisServiceAdapter;
	
	
	private UserValidationService<JobSeeker> jobSeekerValidator;	
	
	
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao, @Qualifier("MernisV") UserValidationService<JobSeeker> mernisServiceAdapter,
			@Qualifier("JobSeekerV") UserValidationService<JobSeeker> jobSeekerValidator) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.mernisServiceAdapter = mernisServiceAdapter;
		this.jobSeekerValidator = jobSeekerValidator;
	}

	


	

	@Override
	public List<JobSeeker> getAll() {
		// TODO Auto-generated method stub
		return this.jobSeekerDao.findAll();
	}

	@Override
	public JobSeeker get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(JobSeeker jobSeeker) throws RemoteException {
		
		
		if(!jobSeekerValidator.validate(jobSeeker)) {
			System.out.println("Alan kontrolü başarısız.");
			return false;

		}
		else if(!mernisServiceAdapter.validate(jobSeeker)) {
			System.out.println("");
			return false; 
		}
		
		else if (this.checkIfEmailAddressExists(jobSeeker)) {
			System.out.println("");
			return false;
		}
		
		else if(this.checkIfNationalIdNoExists(jobSeeker)) {
			System.out.println("");
			return false;
		}
		
		
		this.jobSeekerDao.saveAndFlush(jobSeeker);
		System.out.println("Kayıt başarılı bir şekilde gerçekleşti.");
		return true;
	}

	

	@Override
	public void update(JobSeeker jobSeeker) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(JobSeeker jobSeeker) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void activateJobSeeker(JobSeeker jobSeeker) {
		
		
	}

	
	private boolean checkIfEmailAddressExists(JobSeeker jobSeeker) {
		boolean isEmailAddressExists = this.jobSeekerDao.findAll().stream()
				.filter(jS -> jS.getEmailAddress().equals(jobSeeker.getEmailAddress()))
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
