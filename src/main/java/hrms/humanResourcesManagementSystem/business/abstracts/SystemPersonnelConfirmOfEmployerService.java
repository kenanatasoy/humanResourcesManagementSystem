package hrms.humanResourcesManagementSystem.business.abstracts;

import java.util.List;

import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.entities.concretes.SystemPersonnelConfirmOfEmployer;

public interface SystemPersonnelConfirmOfEmployerService {
	DataResult<List<SystemPersonnelConfirmOfEmployer>> getAll();
	DataResult<SystemPersonnelConfirmOfEmployer> get(int id);
	DataResult<SystemPersonnelConfirmOfEmployer> findByEmployerId(int employerId);
	Result add(SystemPersonnelConfirmOfEmployer systemPersonnelConfirmOfEmployer);
}
