package hrms.humanResourcesManagementSystem.business.abstracts;

import java.util.List;

import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.entities.concretes.City;

public interface CityService {
	DataResult<List<City>> getAll();
	DataResult<City> get(int id);
	Result add(City city);
	Result update(City city);
	Result delete(City city);
}
