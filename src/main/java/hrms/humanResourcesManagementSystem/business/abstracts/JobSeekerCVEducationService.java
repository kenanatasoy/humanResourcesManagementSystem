package hrms.humanResourcesManagementSystem.business.abstracts;

import java.util.List;

import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.entities.concretes.JobSeekerCVEducation;
import hrms.humanResourcesManagementSystem.entities.dtos.JobSeekerCVEducationAddDto;

public interface JobSeekerCVEducationService {
	
	DataResult<List<JobSeekerCVEducation>> getAll();
	DataResult<List<JobSeekerCVEducation>> getAllByJobSeekerCVIdOrderByGraduationDateDesc(int jobSeekerCVId);
	DataResult<JobSeekerCVEducation> get(int id);
	Result add(JobSeekerCVEducationAddDto jobSeekerCVEducationAddDto);
	Result add(JobSeekerCVEducation jobSeekerCVEducation);
	Result update(JobSeekerCVEducation jobSeekerCVEducation);
	Result delete(JobSeekerCVEducation jobSeekerCVEducation);

}
