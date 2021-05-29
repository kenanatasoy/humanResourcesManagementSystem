package hrms.humanResourcesManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.humanResourcesManagementSystem.business.abstracts.JobTitleService;
import hrms.humanResourcesManagementSystem.core.utilities.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.Result;
import hrms.humanResourcesManagementSystem.core.utilities.SuccessDataResult;
import hrms.humanResourcesManagementSystem.core.utilities.SuccessResult;
import hrms.humanResourcesManagementSystem.dataAccess.abstracts.JobTitleDao;
import hrms.humanResourcesManagementSystem.entities.JobTitle;

@Service
public class JobTitleManager implements JobTitleService {

	
	@Autowired
	private JobTitleDao jobTitleDao;
	
	
	@Override
	public DataResult<List<JobTitle>> getAll() {
		return new SuccessDataResult<List<JobTitle>>(this.jobTitleDao.findAll());
	}

	@Override
	public DataResult<JobTitle> get(int id) {
		return null;
	}

	@Override
	public Result add(JobTitle jobTitle) {
		return new SuccessResult();
	}

	@Override
	public Result update(JobTitle jobTitle) {
		return new SuccessResult();
	}

	@Override
	public Result delete(JobTitle jobTitle) {
		return new SuccessResult();
	}

	
}
