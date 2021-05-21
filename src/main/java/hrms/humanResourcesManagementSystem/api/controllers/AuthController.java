package hrms.humanResourcesManagementSystem.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.humanResourcesManagementSystem.business.abstracts.AuthService;

@RestController
@RequestMapping("/api/auth/")
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
}
