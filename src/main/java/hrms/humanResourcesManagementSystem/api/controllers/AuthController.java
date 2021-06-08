package hrms.humanResourcesManagementSystem.api.controllers;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import hrms.humanResourcesManagementSystem.business.abstracts.AuthService;
import hrms.humanResourcesManagementSystem.core.utilities.results.ErrorDataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.entities.concretes.Employer;
import hrms.humanResourcesManagementSystem.entities.concretes.JobSeeker;

@RestController
@RequestMapping("/api/auth/")
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	
	@PostMapping("registerjobseeker")
	public ResponseEntity<?> registerJobSeeker(@Valid @RequestBody JobSeeker jobSeeker) throws RemoteException{
		
		Result result = this.authService.registerJobSeeker(jobSeeker);
		
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		else {
			return ResponseEntity.badRequest().body(result);
		}
	}

	@PostMapping("registeremployer")
	public ResponseEntity<?> registerEmployer(@Valid @RequestBody Employer employer) throws RemoteException{
		
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
	
	
	
	
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions) {
		Map<String,String> validationErrors = new HashMap<String, String>();
		for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}

		ErrorDataResult<Object> errors 
		= new ErrorDataResult<Object>(validationErrors,"Doğrulama hataları");
		return errors;
		
	}
	
	
}


