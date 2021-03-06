package hrms.humanResourcesManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.humanResourcesManagementSystem.business.abstracts.JobTitleService;
import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessDataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessResult;
import hrms.humanResourcesManagementSystem.dataAccess.abstracts.JobTitleDao;
import hrms.humanResourcesManagementSystem.entities.concretes.JobTitle;

@Service
public class JobTitleManager implements JobTitleService {

	
	@Autowired
	private JobTitleDao jobTitleDao;
	
	
	@Override
	public DataResult<List<JobTitle>> getAll() {
		return new SuccessDataResult<List<JobTitle>>(this.jobTitleDao.findAll());
	}

	@Override
	public DataResult<JobTitle> get(Integer id) {
		return new SuccessDataResult<JobTitle>(this.jobTitleDao.getOne(id));
	}

	@Override
	public Result add(JobTitle jobTitle) {
		this.jobTitleDao.saveAndFlush(jobTitle);
		return new SuccessResult();
	}

//	@Override
//	public Result update(JobTitle jobTitle) {
//		return new SuccessResult();
//	}
//
//	@Override
//	public Result delete(JobTitle jobTitle) {
//		return new SuccessResult();
//	}

	
}
