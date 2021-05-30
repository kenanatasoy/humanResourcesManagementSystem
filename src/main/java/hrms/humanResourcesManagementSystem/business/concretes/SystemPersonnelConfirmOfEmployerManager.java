package hrms.humanResourcesManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.humanResourcesManagementSystem.business.abstracts.SystemPersonnelConfirmOfEmployerService;
import hrms.humanResourcesManagementSystem.core.utilities.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.Result;
import hrms.humanResourcesManagementSystem.core.utilities.SuccessResult;
import hrms.humanResourcesManagementSystem.dataAccess.abstracts.SystemPersonnelConfirmOfEmployerDao;
import hrms.humanResourcesManagementSystem.entities.concretes.SystemPersonnelConfirmOfEmployer;

@Service
public class SystemPersonnelConfirmOfEmployerManager implements SystemPersonnelConfirmOfEmployerService {

	@Autowired
	private SystemPersonnelConfirmOfEmployerDao systemPersonnelConfirmOfEmployerDao;
	
	@Override
	public DataResult<List<SystemPersonnelConfirmOfEmployer>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<SystemPersonnelConfirmOfEmployer> get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result add(SystemPersonnelConfirmOfEmployer systemPersonnelConfirmOfEmployer) {
		this.systemPersonnelConfirmOfEmployerDao.saveAndFlush(systemPersonnelConfirmOfEmployer);
		return new SuccessResult();
	}

}
