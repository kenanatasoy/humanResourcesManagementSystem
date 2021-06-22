package hrms.humanResourcesManagementSystem.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.humanResourcesManagementSystem.business.abstracts.JobTitleService;
import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.entities.concretes.JobTitle;

@RestController
@RequestMapping("/api/jobtitles/")
@CrossOrigin
public class JobTitlesController {

	@Autowired
	private JobTitleService jobTitleService;


	@GetMapping("getall")
	public ResponseEntity<?> getAll() {
		
		DataResult<List<JobTitle>> dataResult = this.jobTitleService.getAll();
		
		if (dataResult.isSuccess()) {
			return ResponseEntity.ok(dataResult);
		} 
		else {
			return ResponseEntity.badRequest().body(dataResult);
		}
		
	}

	@GetMapping("getbyid")
	public ResponseEntity<?> get(Integer id) {
		
		DataResult<JobTitle> dataResult = this.jobTitleService.get(id);
		
		if (dataResult.isSuccess()) {
			return ResponseEntity.ok(dataResult);
		} 
		else {
			return ResponseEntity.badRequest().body(dataResult);
		}
	}
	
	@PostMapping("add")
	public ResponseEntity<?> add(@Valid @RequestBody JobTitle jobTitle) {
		
		Result result = this.jobTitleService.add(jobTitle);
		
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		} 
		else {
			return ResponseEntity.badRequest().body(result);
		}
	}
	
	
	
//	@PostMapping("update")
//	public Result update(JobTitle jobTitle) {
//		return this.jobTitleService.update(jobTitle);
//	}
	
//	@PostMapping("delete")
//	public Result delete(JobTitle jobTitle) {
//		return this.jobTitleService.delete(jobTitle);
//	}


}
