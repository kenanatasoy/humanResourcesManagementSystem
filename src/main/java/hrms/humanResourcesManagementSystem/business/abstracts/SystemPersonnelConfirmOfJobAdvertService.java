package hrms.humanResourcesManagementSystem.business.abstracts;

import java.util.List;

import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.entities.concretes.SystemPersonnelConfirmOfJobAdvert;

public interface SystemPersonnelConfirmOfJobAdvertService {
	
	DataResult<List<SystemPersonnelConfirmOfJobAdvert>> getAll();
	DataResult<SystemPersonnelConfirmOfJobAdvert> get(int id);
	DataResult<SystemPersonnelConfirmOfJobAdvert> findByJobAdvertId(int jobAdvertId);
	Result add(SystemPersonnelConfirmOfJobAdvert systemPersonnelConfirmOfJobAdvert);

}
