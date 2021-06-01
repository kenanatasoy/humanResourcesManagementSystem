package hrms.humanResourcesManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.humanResourcesManagementSystem.business.abstracts.SystemPersonnelConfirmService;
import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessResult;
import hrms.humanResourcesManagementSystem.dataAccess.abstracts.SystemPersonnelConfirmDao;
import hrms.humanResourcesManagementSystem.entities.concretes.SystemPersonnelConfirm;

@Service
public class SystemPersonnelConfirmManager implements SystemPersonnelConfirmService{

	@Autowired
	private SystemPersonnelConfirmDao systemPersonnelConfirmDao;
	
	@Override
	public DataResult<List<SystemPersonnelConfirm>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<SystemPersonnelConfirm> get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result add(SystemPersonnelConfirm systemPersonnelConfirm) {
		this.systemPersonnelConfirmDao.saveAndFlush(systemPersonnelConfirm);
		return new SuccessResult();
	}

}
