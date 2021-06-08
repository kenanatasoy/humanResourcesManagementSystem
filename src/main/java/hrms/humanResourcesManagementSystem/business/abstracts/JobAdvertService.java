package hrms.humanResourcesManagementSystem.business.abstracts;

import java.util.List;

import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.entities.concretes.JobAdvert;
import hrms.humanResourcesManagementSystem.entities.dtos.JobAdvertAddDto;
import hrms.humanResourcesManagementSystem.entities.dtos.JobAdvertDto;

public interface JobAdvertService {
	
	DataResult<List<JobAdvertDto>> getJobAdvertDtosByActiveTrue();
	DataResult<List<JobAdvertDto>> getJobAdvertDtosByPublishedDateTimeAndActiveTrue();
	DataResult<List<JobAdvertDto>> getJobAdvertDtosByEmployerIdAndActiveTrue(int employerId);
	DataResult<List<JobAdvert>> getAll();
	DataResult<JobAdvert> get(int id);
	Result add (JobAdvertAddDto jobAdvertAddDto);
	Result update(JobAdvert jobAdvert);
	Result delete(JobAdvert jobAdvert);
	Result toggleJobAdActivePassive(int jobAdvertId);
	
}
