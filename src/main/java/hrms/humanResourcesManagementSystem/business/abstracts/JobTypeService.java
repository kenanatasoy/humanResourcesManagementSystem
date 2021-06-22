package hrms.humanResourcesManagementSystem.business.abstracts;
import java.util.List;

import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.entities.concretes.JobType;

public interface JobTypeService {

	DataResult<List<JobType>> getAll();
	DataResult<JobType> get(int id);
	Result add(JobType jobType);
	
}
