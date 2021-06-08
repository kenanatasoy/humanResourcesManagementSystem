package hrms.humanResourcesManagementSystem.business.abstracts;

import java.util.List;

import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.entities.concretes.JobSeekerCV;
import hrms.humanResourcesManagementSystem.entities.dtos.JobSeekerCVAddDto;

public interface JobSeekerCVService {
	
	DataResult<List<JobSeekerCV>> getAll();
	DataResult<JobSeekerCV> get(int id);
	Result add(JobSeekerCVAddDto jobSeekerCVAddDto);
	Result add(JobSeekerCV jobSeekerCV);
	Result update(JobSeekerCV jobSeekerCV);
	Result delete(JobSeekerCV jobSeekerCV);

}
