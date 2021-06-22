package hrms.humanResourcesManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.humanResourcesManagementSystem.business.abstracts.JobTypeService;
import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessDataResult;
import hrms.humanResourcesManagementSystem.dataAccess.abstracts.JobTypeDao;
import hrms.humanResourcesManagementSystem.entities.concretes.JobType;

@Service
public class JobTypeManager implements JobTypeService {

	@Autowired
	private JobTypeDao jobTypeDao;
	
	@Override
	public DataResult<List<JobType>> getAll() {
		return new SuccessDataResult<List<JobType>>(this.jobTypeDao.findAll());
	}

	@Override
	public DataResult<JobType> get(int id) {
		return new SuccessDataResult<JobType>(this.jobTypeDao.getOne(id));
	}

	@Override
	public Result add(JobType jobType) {
		// TODO Auto-generated method stub
		return null;
	}

}
