package hrms.humanResourcesManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.humanResourcesManagementSystem.business.abstracts.JobSeekerCVLanguageService;
import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessDataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessResult;
import hrms.humanResourcesManagementSystem.dataAccess.abstracts.JobSeekerCVLanguageDao;
import hrms.humanResourcesManagementSystem.entities.concretes.JobSeekerCVLanguage;

@Service
public class JobSeekerCVLanguageManager implements JobSeekerCVLanguageService{

	@Autowired
	private JobSeekerCVLanguageDao jobSeekerCVLanguageDao;
	
	
	@Override
	public DataResult<List<JobSeekerCVLanguage>> getAll() {
		return new SuccessDataResult<List<JobSeekerCVLanguage>>(this.jobSeekerCVLanguageDao.findAll());
	}

	@Override
	public DataResult<JobSeekerCVLanguage> get(int id) {
		return new SuccessDataResult<JobSeekerCVLanguage>(this.jobSeekerCVLanguageDao.getOne(id));
	}

	@Override
	public Result add(JobSeekerCVLanguage jobSeekerCVLanguage) {
		this.jobSeekerCVLanguageDao.saveAndFlush(jobSeekerCVLanguage);
		return new SuccessResult();
	}

	@Override
	public Result update(JobSeekerCVLanguage jobSeekerCVLanguage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(JobSeekerCVLanguage jobSeekerCVLanguage) {
		// TODO Auto-generated method stub
		return null;
	}

}
