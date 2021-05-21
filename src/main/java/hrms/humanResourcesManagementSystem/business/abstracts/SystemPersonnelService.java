package hrms.humanResourcesManagementSystem.business.abstracts;

import java.util.List;

import hrms.humanResourcesManagementSystem.entities.Employer;
import hrms.humanResourcesManagementSystem.entities.SystemPersonnel;

public interface SystemPersonnelService {
	
	List<SystemPersonnel> getAll();
	SystemPersonnel get(int id);
	void add(SystemPersonnel systemPersonnel);
	void update(SystemPersonnel systemPersonnel);
	void delete(SystemPersonnel systemPersonnel);
	void approve(Employer employer, SystemPersonnel systemPersonnel);
}
