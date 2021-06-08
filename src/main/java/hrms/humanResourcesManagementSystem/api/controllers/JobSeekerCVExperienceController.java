package hrms.humanResourcesManagementSystem.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.humanResourcesManagementSystem.business.abstracts.JobSeekerCVExperienceService;
import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.entities.concretes.JobSeekerCVExperience;
import hrms.humanResourcesManagementSystem.entities.dtos.JobSeekerCVExperienceAddDto;

@RestController
@RequestMapping("/api/jobseekercvexperiences/")
public class JobSeekerCVExperienceController {
	
	@Autowired
	private JobSeekerCVExperienceService jobSeekerCVExperienceService;
	
	
	@GetMapping("getall")
	public ResponseEntity<?> getAll(){
		
		DataResult<List<JobSeekerCVExperience>> dataResult = this.jobSeekerCVExperienceService.getAll();
		
		if (dataResult.isSuccess()) {
			return ResponseEntity.ok(dataResult);
		}
		else {
			return ResponseEntity.badRequest().body(dataResult);
		}
		
	}
	
	@GetMapping("getAllByJobSeekerCVIdOrderByEndingDateDesc")
	public ResponseEntity<?> getAllByJobSeekerCVIdOrderByEndingDateDesc(int jobSeekerCVId){
		
		DataResult<List<JobSeekerCVExperience>> dataResult = this.jobSeekerCVExperienceService
				.getAllByJobSeekerCVIdOrderByEndingDateDesc(jobSeekerCVId);
		
		if (dataResult.isSuccess()) {
			return ResponseEntity.ok(dataResult);
		}
		else {
			return ResponseEntity.badRequest().body(dataResult);
		}
		
	}
	
	@GetMapping("getbyid")
	public ResponseEntity<?> get(int id) {
		
		DataResult<JobSeekerCVExperience> dataResult = this.jobSeekerCVExperienceService.get(id);
		
		if (dataResult.isSuccess()) {
			return ResponseEntity.ok(dataResult);
		}
		else {
			return ResponseEntity.badRequest().body(dataResult);
		}
		
	}
	
	@PostMapping("add")
	public ResponseEntity<?> add(@RequestBody JobSeekerCVExperienceAddDto jobSeekerCVExperienceAddDto){
		
		Result result = this.jobSeekerCVExperienceService.add(jobSeekerCVExperienceAddDto);
		
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		else {
			return ResponseEntity.badRequest().body(result);
		}
		
	}
}
