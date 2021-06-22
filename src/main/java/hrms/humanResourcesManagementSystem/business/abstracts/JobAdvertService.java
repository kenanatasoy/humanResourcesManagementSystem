package hrms.humanResourcesManagementSystem.business.abstracts;

import java.util.List;

import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.entities.concretes.JobAdvert;
import hrms.humanResourcesManagementSystem.entities.dtos.JobAdvertAddDto;
import hrms.humanResourcesManagementSystem.entities.dtos.JobAdvertGetDto;

public interface JobAdvertService {
	
	DataResult<List<JobAdvertGetDto>> getConfirmedJobAdvertDtosByActiveTrue();
	DataResult<List<JobAdvertGetDto>> getConfirmedJobAdvertDtosByPublishedDateTimeAndActiveTrue();
	DataResult<List<JobAdvertGetDto>> getConfirmedJobAdvertDtosByEmployerIdAndActiveTrue(int employerId);
	DataResult<JobAdvertGetDto> getConfirmedJobAdvertDtoByIdAndActiveTrue(int jobAdvertId);
	DataResult<List<JobAdvert>> getAll();
	DataResult<JobAdvert> get(int id);
	Result add (JobAdvertAddDto jobAdvertAddDto);
	Result add (JobAdvert jobAdvert);
	Result update(JobAdvert jobAdvert);
	Result delete(JobAdvert jobAdvert);
	Result toggleJobAdActivePassive(Integer jobAdvertId, boolean isActivated);
	
}
