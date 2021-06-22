package hrms.humanResourcesManagementSystem.business.abstracts;

import java.util.List;

import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.entities.concretes.Gender;

public interface GenderService {

	DataResult<List<Gender>> getAll();
	DataResult<Gender> get(int id);
}
