package hrms.humanResourcesManagementSystem.api.controllers;

import java.rmi.RemoteException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.humanResourcesManagementSystem.business.abstracts.AuthService;
import hrms.humanResourcesManagementSystem.core.utilities.Result;
import hrms.humanResourcesManagementSystem.entities.Employer;
import hrms.humanResourcesManagementSystem.entities.JobSeeker;

@RestController
@RequestMapping("/api/auth/")
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	@PostMapping("registerjobseeker")
	public ResponseEntity<?> registerJobSeeker(@RequestBody JobSeeker jobSeeker) throws RemoteException{
		
		Result result = this.authService.registerJobSeeker(jobSeeker);
		
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		else {
			return ResponseEntity.badRequest().body(result);
		}
	}

	@PostMapping("registeremployer")
	public ResponseEntity<?> registerEmployer(@RequestBody Employer employer) throws RemoteException{
		
		Result result = this.authService.registerEmployer(employer);
		
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		else {
			return ResponseEntity.badRequest().body(result);
		}
	}
	
	
	
	@PostMapping("verifyjobseeker")
	public ResponseEntity<?> verifyJobSeeker(String userVCode, int jobSeekerId){
		
		Result result = this.authService.verifyJobSeeker(userVCode, jobSeekerId);
		
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		else {
			return ResponseEntity.badRequest().body(result);
		}
	}
	
	@PostMapping("verifyemployer")
	public ResponseEntity<?> verifyEmployer(String userVCode, int employerId){
		
		Result result = this.authService.verifyEmployer(userVCode, employerId);
		
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		else {
			return ResponseEntity.badRequest().body(result);
		}	
	}
	
	@PostMapping("confirmemployer")
	public ResponseEntity<?> confirmEmployer(int systemPersonnelId, int employerId){ 
		
		Result result = this.authService.confirmEmployer(systemPersonnelId, employerId);
		
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		else {
			return ResponseEntity.badRequest().body(result);
		}
		
	}
}
