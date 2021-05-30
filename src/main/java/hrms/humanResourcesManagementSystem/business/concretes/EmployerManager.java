package hrms.humanResourcesManagementSystem.business.concretes;

import java.rmi.RemoteException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import hrms.humanResourcesManagementSystem.business.abstracts.EmployerService;
import hrms.humanResourcesManagementSystem.business.abstracts.UserValidationService;
import hrms.humanResourcesManagementSystem.core.utilities.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.ErrorResult;
import hrms.humanResourcesManagementSystem.core.utilities.Result;
import hrms.humanResourcesManagementSystem.core.utilities.SuccessDataResult;
import hrms.humanResourcesManagementSystem.core.utilities.SuccessResult;
import hrms.humanResourcesManagementSystem.dataAccess.abstracts.EmployerDao;
import hrms.humanResourcesManagementSystem.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {
	
	private EmployerDao employerDao;
	private UserValidationService<Employer> employerValidator;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao,
			@Qualifier("EmployerV") UserValidationService<Employer> employerValidator) {
		super();
		this.employerDao = employerDao;
		this.employerValidator = employerValidator;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "Tüm işverenler listelendi");
	}

	@Override
	public DataResult<Employer> get(int id) {
		return new SuccessDataResult<Employer>(this.employerDao.getOne(id));
	}

	@Override
	public Result add(Employer employer) throws RemoteException {
		if(!this.employerValidator.validate(employer).isSuccess()) {
			return new ErrorResult(this.employerValidator.validate(employer).getMessage());
		}
		this.employerDao.saveAndFlush(employer);
		return new SuccessResult();
	}

	@Override
	public Result update(Employer employer) {
		return new SuccessResult();
	}

	@Override
	public Result delete(Employer employer) {
		return new SuccessResult();
	}
	
	
	
//	boolean stat = (1 == 1) ? true : false;
	
	

	
}
