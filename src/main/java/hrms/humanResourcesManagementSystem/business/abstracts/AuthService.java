package hrms.humanResourcesManagementSystem.business.abstracts;

import hrms.humanResourcesManagementSystem.core.User;

public interface AuthService {

	boolean register(User user);
	void login(String email, String password);

}
