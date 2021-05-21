package hrms.humanResourcesManagementSystem.business.concretes;

import org.springframework.stereotype.Service;

import hrms.humanResourcesManagementSystem.business.abstracts.AuthService;
import hrms.humanResourcesManagementSystem.core.User;


@Service
public class AuthManager implements AuthService{

	
	
	@Override
	public boolean register(User user) {
		return true;
	}

	@Override
	public void login(String email, String password) {
		
	}

	
}
