package hrms.humanResourcesManagementSystem.business.abstracts;

import java.util.List;

import hrms.humanResourcesManagementSystem.core.utilities.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.Result;
import hrms.humanResourcesManagementSystem.entities.SystemPersonnel;

public interface SystemPersonnelService {
	
	DataResult<List<SystemPersonnel>> getAll();
	DataResult<SystemPersonnel> get(int id);
	Result add(SystemPersonnel systemPersonnel);
	Result update(SystemPersonnel systemPersonnel);
	Result delete(int systemPersonnelId);
}
