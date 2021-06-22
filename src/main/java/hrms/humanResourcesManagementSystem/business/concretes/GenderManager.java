package hrms.humanResourcesManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.humanResourcesManagementSystem.business.abstracts.GenderService;
import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessDataResult;
import hrms.humanResourcesManagementSystem.dataAccess.abstracts.GenderDao;
import hrms.humanResourcesManagementSystem.entities.concretes.Gender;

@Service
public class GenderManager implements GenderService{

	@Autowired
	private GenderDao genderDao;
	
	@Override
	public DataResult<List<Gender>> getAll() {
		return new SuccessDataResult<List<Gender>>(this.genderDao.findAll());
	}

	@Override
	public DataResult<Gender> get(int id) {
		return new SuccessDataResult<Gender>(this.genderDao.getOne(id));
	}

}
