package hrms.humanResourcesManagementSystem.business.abstracts;

import java.util.List;

import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.entities.concretes.JobSeekerCVLanguage;

public interface JobSeekerCVLanguageService {
	
	DataResult<List<JobSeekerCVLanguage>> getAll();
	DataResult<JobSeekerCVLanguage> get(int id);
	Result add(JobSeekerCVLanguage jobSeekerCVLanguage);
	Result update(JobSeekerCVLanguage jobSeekerCVLanguage);
	Result delete(JobSeekerCVLanguage jobSeekerCVLanguage);

}
