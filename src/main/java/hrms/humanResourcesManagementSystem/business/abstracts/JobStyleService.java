package hrms.humanResourcesManagementSystem.business.abstracts;

import java.util.List;

import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.entities.concretes.JobStyle;

public interface JobStyleService {
	
	DataResult<List<JobStyle>> getAll();
	DataResult<JobStyle> get(int id);
	Result add(JobStyle jobStyle);

}
