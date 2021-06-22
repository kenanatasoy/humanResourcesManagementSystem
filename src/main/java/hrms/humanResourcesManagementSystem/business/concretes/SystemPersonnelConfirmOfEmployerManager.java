package hrms.humanResourcesManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.humanResourcesManagementSystem.business.abstracts.SystemPersonnelConfirmOfEmployerService;
import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.ErrorDataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessDataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessResult;
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
	public DataResult<SystemPersonnelConfirmOfEmployer> findByEmployerId(int employerId) {
		SystemPersonnelConfirmOfEmployer systemPersonnelConfirmOfEmployer = 
				this.systemPersonnelConfirmOfEmployerDao.findByEmployerId(employerId).orElse(null);
		if (systemPersonnelConfirmOfEmployer == null) {
			return new ErrorDataResult<SystemPersonnelConfirmOfEmployer>();
		}
		
		return new SuccessDataResult<SystemPersonnelConfirmOfEmployer>(systemPersonnelConfirmOfEmployer);
	}

	@Override
	public Result add(SystemPersonnelConfirmOfEmployer systemPersonnelConfirmOfEmployer) {
		this.systemPersonnelConfirmOfEmployerDao.saveAndFlush(systemPersonnelConfirmOfEmployer);
		return new SuccessResult();
	}

	

}
