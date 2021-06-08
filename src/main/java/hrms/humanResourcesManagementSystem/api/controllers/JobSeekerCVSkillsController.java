package hrms.humanResourcesManagementSystem.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.humanResourcesManagementSystem.business.abstracts.JobSeekerCVSkillService;
import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.entities.concretes.JobSeekerCVSkill;

@RestController
@RequestMapping("/api/jobseekercvskills/")
public class JobSeekerCVSkillsController {

	@Autowired
	private JobSeekerCVSkillService jobSeekerCVSkillService;
	
	
	@GetMapping("getall")
	public ResponseEntity<?> getAll(){
		
		DataResult<List<JobSeekerCVSkill>> dataResult = this.jobSeekerCVSkillService.getAll();
		
		if (dataResult.isSuccess()) {
			return ResponseEntity.ok(dataResult);
		}
		else {
			return ResponseEntity.badRequest().body(dataResult);
		}
	}
	
	@GetMapping("getbyid")
	public ResponseEntity<?> get(int id) {
		
		DataResult<JobSeekerCVSkill> dataResult = this.jobSeekerCVSkillService.get(id);
		
		if (dataResult.isSuccess()) {
			return ResponseEntity.ok(dataResult);
		}
		else {
			return ResponseEntity.badRequest().body(dataResult);
		}
		
	}
	
	@PostMapping("add")
	public ResponseEntity<?> add(@RequestBody JobSeekerCVSkill jobSeekerCVSkill){
		
		Result result = this.jobSeekerCVSkillService.add(jobSeekerCVSkill);
		
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		else {
			return ResponseEntity.badRequest().body(result);
		}
		
	}
	
	
	
}
