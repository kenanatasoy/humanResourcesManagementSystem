package hrms.humanResourcesManagementSystem.business.abstracts;

import java.util.List;

import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.entities.concretes.JobSeekerCVSkill;

public interface JobSeekerCVSkillService {
	
	DataResult<List<JobSeekerCVSkill>> getAll();
	DataResult<JobSeekerCVSkill> get(int id);
	Result add(JobSeekerCVSkill jobSeekerCVSkill);
	Result update(JobSeekerCVSkill jobSeekerCVSkill);
	Result delete(JobSeekerCVSkill jobSeekerCVSkill);
	
}
