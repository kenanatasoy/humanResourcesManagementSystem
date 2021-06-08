package hrms.humanResourcesManagementSystem.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.humanResourcesManagementSystem.business.abstracts.JobTitleService;
import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.entities.concretes.JobTitle;

@RestController
@RequestMapping("/api/jobtitles/")
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
	public ResponseEntity<?> get(int id) {
		
		DataResult<JobTitle> dataResult = this.jobTitleService.get(id);
		
		if (dataResult.isSuccess()) {
			return ResponseEntity.ok(dataResult);
		} 
		else {
			return ResponseEntity.badRequest().body(dataResult);
		}
	}

//	@PostMapping("add")
//	public Result add(JobTitle jobTitle) {
//		return this.jobTitleService.add(jobTitle);
//	}
	
//	@PostMapping("update")
//	public Result update(JobTitle jobTitle) {
//		return this.jobTitleService.update(jobTitle);
//	}
	
//	@PostMapping("delete")
//	public Result delete(JobTitle jobTitle) {
//		return this.jobTitleService.delete(jobTitle);
//	}


}
