package hrms.humanResourcesManagementSystem.business.abstracts;

import java.util.List;

import hrms.humanResourcesManagementSystem.entities.Employer;

public interface EmployerService {
	
	List<Employer> getAll();
	Employer get(int id);
	void add(Employer employer);
	void update(Employer employer);
	void delete(Employer employer);

}
