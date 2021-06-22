package hrms.humanResourcesManagementSystem.business.abstracts;

import java.util.List;

import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.entities.concretes.JobSeekerCVLanguage;
import hrms.humanResourcesManagementSystem.entities.dtos.JobSeekerCVLanguageGetDto;

public interface JobSeekerCVLanguageService {
	
//	DataResult<List<JobSeekerCVLanguage>> getAll();
//	DataResult<JobSeekerCVLanguage> get(Integer id);
	DataResult<List<JobSeekerCVLanguageGetDto>> getJobSeekerCVLanguagesGetDtos();
	DataResult<JobSeekerCVLanguageGetDto> getJobSeekerCVLanguagesGetDtoById(Integer jobSeekerCVLanguageId);
	Result add(JobSeekerCVLanguage jobSeekerCVLanguage);
	Result update(JobSeekerCVLanguage jobSeekerCVLanguage);
	Result deleteById(Integer jobSeekerCVLanguageId);

}
