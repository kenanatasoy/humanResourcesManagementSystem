package hrms.humanResourcesManagementSystem.business.abstracts;

import java.util.List;

import hrms.humanResourcesManagementSystem.entities.JobTitle;

public interface JobTitleService {
	
	List<JobTitle> getAll();
	JobTitle get(int id);
	void add(JobTitle jobTitle);
	void update(JobTitle jobTitle);
	void delete(JobTitle jobTitle);

}
