package hrms.humanResourcesManagementSystem.business.abstracts;

import java.util.List;

import hrms.humanResourcesManagementSystem.core.utilities.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.Result;
import hrms.humanResourcesManagementSystem.entities.concretes.SystemPersonnelConfirm;

public interface SystemPersonnelConfirmService {
	DataResult<List<SystemPersonnelConfirm>> getAll();
	DataResult<SystemPersonnelConfirm> get(int id);
	Result add(SystemPersonnelConfirm systemPersonnelConfirm);
}
