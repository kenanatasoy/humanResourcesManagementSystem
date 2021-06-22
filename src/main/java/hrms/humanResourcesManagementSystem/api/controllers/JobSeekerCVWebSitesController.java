package hrms.humanResourcesManagementSystem.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.humanResourcesManagementSystem.business.abstracts.JobSeekerCVWebSiteService;
import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.entities.concretes.JobSeekerCVWebSite;

@RestController
@RequestMapping("/api/jobseekercvwebsites/")
@CrossOrigin
public class JobSeekerCVWebSitesController {
	
	@Autowired
	private JobSeekerCVWebSiteService jobSeekerCVWebSiteService;
	
	@GetMapping("getall")
	public ResponseEntity<?> getAll(){
		
		DataResult<List<JobSeekerCVWebSite>> dataResult = this.jobSeekerCVWebSiteService.getAll();
		
		if (dataResult.isSuccess()) {
			return ResponseEntity.ok(dataResult);
		}
		else {
			return ResponseEntity.badRequest().body(dataResult);
		}
	}
	
	@GetMapping("getbyid")
	public ResponseEntity<?> get(Integer id) {
		
		DataResult<JobSeekerCVWebSite> dataResult = this.jobSeekerCVWebSiteService.get(id);
		
		if (dataResult.isSuccess()) {
			return ResponseEntity.ok(dataResult);
		}
		else {
			return ResponseEntity.badRequest().body(dataResult);
		}
		
	}
	
	@PostMapping("add")
	public ResponseEntity<?> add(@RequestBody JobSeekerCVWebSite jobSeekerCVWebSite){
		
		Result result = this.jobSeekerCVWebSiteService.add(jobSeekerCVWebSite);
		
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		else {
			return ResponseEntity.badRequest().body(result);
		}
		
	}
	
	@DeleteMapping("deletebyid")
	public ResponseEntity<?> deleteById(Integer jobSeekerCVLanguageId){
		
		Result result = this.jobSeekerCVWebSiteService.deleteById(jobSeekerCVLanguageId);
		
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		else {
			return ResponseEntity.badRequest().body(result);
		}
		
	}
}
