package hrms.humanResourcesManagementSystem.business.abstracts;

import java.util.List;

import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.entities.concretes.JobTitle;

public interface JobTitleService {
	
	DataResult<List<JobTitle>> getAll();
	DataResult<JobTitle> get(Integer id);
	Result add(JobTitle jobTitle);
//	Result update(JobTitle jobTitle);
//	Result delete(JobTitle jobTitle);

}
