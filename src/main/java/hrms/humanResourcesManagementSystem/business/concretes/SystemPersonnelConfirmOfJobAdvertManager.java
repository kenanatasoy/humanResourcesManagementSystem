package hrms.humanResourcesManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.humanResourcesManagementSystem.business.abstracts.SystemPersonnelConfirmOfJobAdvertService;
import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.ErrorDataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessDataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessResult;
import hrms.humanResourcesManagementSystem.dataAccess.abstracts.SystemPersonnelConfirmOfJobAdvertDao;
import hrms.humanResourcesManagementSystem.entities.concretes.SystemPersonnelConfirmOfJobAdvert;

@Service
public class SystemPersonnelConfirmOfJobAdvertManager implements SystemPersonnelConfirmOfJobAdvertService{

	@Autowired
	private SystemPersonnelConfirmOfJobAdvertDao systemPersonnelConfirmOfJobAdvertDao;
	
	@Override
	public DataResult<List<SystemPersonnelConfirmOfJobAdvert>> getAll() {
		return new SuccessDataResult<List<SystemPersonnelConfirmOfJobAdvert>>
		(this.systemPersonnelConfirmOfJobAdvertDao.findAll());
	}

	@Override
	public DataResult<SystemPersonnelConfirmOfJobAdvert> get(int id) {
		return new SuccessDataResult<SystemPersonnelConfirmOfJobAdvert>
		(this.systemPersonnelConfirmOfJobAdvertDao.getOne(id));
	}
	
	@Override
	public DataResult<SystemPersonnelConfirmOfJobAdvert> findByJobAdvertId(int jobAdvertId) {
		SystemPersonnelConfirmOfJobAdvert systemPersonnelConfirmOfJobAdvert = 
				this.systemPersonnelConfirmOfJobAdvertDao.findByJobAdvertId(jobAdvertId).orElse(null);
		if (systemPersonnelConfirmOfJobAdvert == null) {
			return new ErrorDataResult<SystemPersonnelConfirmOfJobAdvert>();
		}
		
		return new SuccessDataResult<SystemPersonnelConfirmOfJobAdvert>(systemPersonnelConfirmOfJobAdvert);
	}

	@Override
	public Result add(SystemPersonnelConfirmOfJobAdvert systemPersonnelConfirmOfJobAdvert) {
		this.systemPersonnelConfirmOfJobAdvertDao.saveAndFlush(systemPersonnelConfirmOfJobAdvert);
		return new SuccessResult();
	}

}
