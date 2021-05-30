package hrms.humanResourcesManagementSystem.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.humanResourcesManagementSystem.business.abstracts.JobAdvertService;
import hrms.humanResourcesManagementSystem.core.utilities.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.Result;
import hrms.humanResourcesManagementSystem.entities.concretes.JobAdvert;
import hrms.humanResourcesManagementSystem.entities.dtos.JobAdvertDto;

@RestController
@RequestMapping("/api/jobadverts/")
public class JobAdvertsController {

	@Autowired
	private JobAdvertService jobAdvertService;
	
	
	@GetMapping("getAllJobAds")
	public ResponseEntity<?> getAllJobAds(){
		
		DataResult<List<JobAdvertDto>> dataResult = this.jobAdvertService.getAllJobAds();
		
		if (dataResult.isSuccess()) {
			return ResponseEntity.ok(dataResult);
		}
		else {
			return ResponseEntity.badRequest().body(dataResult);
		}
	}
	
	@GetMapping("getAll")
	public ResponseEntity<?> getAll(){
		
		DataResult<List<JobAdvert>> dataResult = this.jobAdvertService.getAll();
		
		if (dataResult.isSuccess()) {
			return ResponseEntity.ok(dataResult);
		}
		else {
			return ResponseEntity.badRequest().body(dataResult);
		}
	}
	
	@PostMapping("addjobadvert")
	public ResponseEntity<?> addJobAdvert(@RequestBody JobAdvert jobAdvert) {
		
		Result result = this.jobAdvertService.add(jobAdvert);
		
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		else {
			return ResponseEntity.badRequest().body(result);
		}
	}
	
	@PostMapping("toggleJobAdActivePassive")
	public ResponseEntity<?> toggleJobAdActivePassive(int employerId, int jobAdvertId){
		
		Result result = this.jobAdvertService.toggleJobAdActivePassive(employerId, jobAdvertId);
		
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		else {
			return ResponseEntity.badRequest().body(result);
		}
	}
	
}
