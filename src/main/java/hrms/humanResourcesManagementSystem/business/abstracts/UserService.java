package hrms.humanResourcesManagementSystem.business.abstracts;

import java.util.List;

import hrms.humanResourcesManagementSystem.core.entities.User;
import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;

public interface UserService {
	DataResult<List<User>> getAll();
	DataResult<User> get(int id);
	Result add(User user);
	Result update(User user);
	Result delete(int userId);
}
