package hrms.humanResourcesManagementSystem.business.abstracts;

import java.util.List;

import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.entities.concretes.JobSeekerCVExperience;
import hrms.humanResourcesManagementSystem.entities.dtos.JobSeekerCVExperienceAddDto;

public interface JobSeekerCVExperienceService {

	DataResult<List<JobSeekerCVExperience>> getAll();
	DataResult<List<JobSeekerCVExperience>> getAllByJobSeekerCVIdOrderByEndingDateDesc(int jobSeekerCVId);
	DataResult<JobSeekerCVExperience> get(int id);
	Result add(JobSeekerCVExperienceAddDto jobSeekerCVExperienceAddDto);
	Result update(JobSeekerCVExperience jobSeekerCVExperience);
	Result delete(JobSeekerCVExperience jobSeekerCVExperience);
	
}
