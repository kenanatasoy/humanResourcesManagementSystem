package hrms.humanResourcesManagementSystem.business.abstracts;

import java.util.List;

import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.entities.concretes.JobSeekerCVWebSite;

public interface JobSeekerCVWebSiteService {
	DataResult<List<JobSeekerCVWebSite>> getAll();
	DataResult<JobSeekerCVWebSite> get(Integer id);
	Result add(JobSeekerCVWebSite jobSeekerCVWebSite);
	Result update(JobSeekerCVWebSite jobSeekerCVWebSite);
	Result deleteById(Integer jobSeekerCVWebSiteId);
}
