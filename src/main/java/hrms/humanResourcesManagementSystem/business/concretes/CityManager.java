package hrms.humanResourcesManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.humanResourcesManagementSystem.business.abstracts.CityService;
import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessDataResult;
import hrms.humanResourcesManagementSystem.dataAccess.abstracts.CityDao;
import hrms.humanResourcesManagementSystem.entities.concretes.City;

@Service
public class CityManager implements CityService {

	@Autowired
	private CityDao cityDao;
	
	@Override
	public DataResult<List<City>> getAll() {
		return new SuccessDataResult<List<City>>(this.cityDao.findAll());
	}

	@Override
	public DataResult<City> get(int id) {
		return new SuccessDataResult<City>(this.cityDao.getOne(id));
	}

	@Override
	public Result add(City city) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result update(City city) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(City city) {
		// TODO Auto-generated method stub
		return null;
	}

}
