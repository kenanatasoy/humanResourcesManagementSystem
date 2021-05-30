package hrms.humanResourcesManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.humanResourcesManagementSystem.business.abstracts.SystemPersonnelService;
import hrms.humanResourcesManagementSystem.core.utilities.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.Result;
import hrms.humanResourcesManagementSystem.core.utilities.SuccessDataResult;
import hrms.humanResourcesManagementSystem.core.utilities.SuccessResult;
import hrms.humanResourcesManagementSystem.dataAccess.abstracts.SystemPersonnelDao;
import hrms.humanResourcesManagementSystem.entities.concretes.SystemPersonnel;

@Service
public class SystemPersonnelManager implements SystemPersonnelService {

	
	@Autowired
	private SystemPersonnelDao systemPersonnelDao;
	
	
	@Override
	public DataResult<List<SystemPersonnel>> getAll() {
		return new SuccessDataResult<List<SystemPersonnel>>(this.systemPersonnelDao.findAll());
	}

	@Override
	public DataResult<SystemPersonnel> get(int id) {
		return new SuccessDataResult<SystemPersonnel>(this.systemPersonnelDao.getOne(id));
	}

	@Override
	public Result add(SystemPersonnel systemPersonnel) {
		this.systemPersonnelDao.saveAndFlush(systemPersonnel);
		return new SuccessResult();
	}

	@Override
	public Result update(SystemPersonnel systemPersonnel) {
		return new SuccessResult();
	}

	@Override
	public Result delete(int systemPersonnelId) {
		this.systemPersonnelDao.deleteById(systemPersonnelId);
		return new SuccessResult();
	}

	

	

}
