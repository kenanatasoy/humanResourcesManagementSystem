package hrms.humanResourcesManagementSystem.api.controllers;

import java.rmi.RemoteException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrms.humanResourcesManagementSystem.business.abstracts.AuthService;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.entities.concretes.Employer;
import hrms.humanResourcesManagementSystem.entities.concretes.JobSeeker;

@RestController
@RequestMapping("/api/auth/")
@CrossOrigin
public class AuthController {

	@Autowired
	private AuthService authService;

	@PostMapping("registerjobseeker")
	public ResponseEntity<?> registerJobSeeker(@Valid @RequestBody JobSeeker jobSeeker) throws RemoteException {

		Result result = this.authService.registerJobSeeker(jobSeeker);

		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		} else {
			return ResponseEntity.badRequest().body(result);
		}
	}

	@PostMapping("registeremployer")
	public ResponseEntity<?> registerEmployer(@Valid @RequestBody Employer employer) throws RemoteException {

		Result result = this.authService.registerEmployer(employer);

		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		} else {
			return ResponseEntity.badRequest().body(result);
		}
	}

	@PostMapping("verifyjobseeker")
	public ResponseEntity<?> verifyJobSeeker(String userVCode, Integer jobSeekerId) {

		Result result = this.authService.verifyJobSeeker(userVCode, jobSeekerId);

		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		} else {
			return ResponseEntity.badRequest().body(result);
		}
	}

	@PostMapping("verifyemployer")
	public ResponseEntity<?> verifyEmployer(String userVCode, Integer employerId) {

		Result result = this.authService.verifyEmployer(userVCode, employerId);

		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		} else {
			return ResponseEntity.badRequest().body(result);
		}
	}

	@PostMapping("systemPersonnelConfirmOfEmployer")
	public ResponseEntity<?> confirmEmployer(@Valid @RequestParam Integer systemPersonnelId, @Valid @RequestParam Integer employerId) {

		Result result = this.authService.systemPersonnelConfirmOfEmployer(systemPersonnelId, employerId);

		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		} else {
			return ResponseEntity.badRequest().body(result);
		}

	}

	@PostMapping("systemPersonnelConfirmOfJobAdvert")
	public ResponseEntity<?> systemPersonnelConfirmOfJobAdvert(@Valid @RequestParam Integer systemPersonnelId, @Valid @RequestParam Integer jobAdvertId) {

		Result result = this.authService.systemPersonnelConfirmOfJobAdvert(systemPersonnelId, jobAdvertId);

		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		} else {
			return ResponseEntity.badRequest().body(result);
		}

	}

}
