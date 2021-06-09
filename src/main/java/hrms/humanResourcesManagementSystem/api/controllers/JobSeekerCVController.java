package hrms.humanResourcesManagementSystem.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.humanResourcesManagementSystem.business.abstracts.JobSeekerCVService;
import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.entities.concretes.JobSeekerCV;
import hrms.humanResourcesManagementSystem.entities.dtos.JobSeekerCVAddDto;

@RestController
@RequestMapping("/api/jobseekercvs/")
public class JobSeekerCVController {

	@Autowired
	private JobSeekerCVService jobSeekerCVService;
	
	
	@GetMapping("getall")
	public ResponseEntity<?> getAll() {

		DataResult<List<JobSeekerCV>> dataResult = this.jobSeekerCVService.getAll();

		if (dataResult.isSuccess()) {
			return ResponseEntity.ok(dataResult);
		} else {
			return ResponseEntity.badRequest().body(dataResult);
		}

	}
	
	@GetMapping("getByJobSeekerId")
	public ResponseEntity<?> getByJobSeekerId(int jobSeekerId){
		
		DataResult<List<JobSeekerCV>> dataResult = this.jobSeekerCVService.getByJobSeekerId(jobSeekerId);
		
		if (dataResult.isSuccess()) {
			return ResponseEntity.ok(dataResult);
		} else {
			return ResponseEntity.badRequest().body(dataResult);
		}
		
	}

	@GetMapping("getbyid")
	public ResponseEntity<?> get(int id) {
		
		DataResult<JobSeekerCV> dataResult = this.jobSeekerCVService.get(id);

		if (dataResult.isSuccess()) {
			return ResponseEntity.ok(dataResult);
		} else {
			return ResponseEntity.badRequest().body(dataResult);
		}
		
	}

	@PostMapping("add")
	public ResponseEntity<?> add(@RequestBody JobSeekerCVAddDto jobSeekerCVAddDto) {

		Result result = this.jobSeekerCVService.add(jobSeekerCVAddDto);
		
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		} 
		else {
			return ResponseEntity.badRequest().body(result);
		}
		
	}

	@PostMapping("addRawJobSekerCV")
	public ResponseEntity<?> addRawJobSeekerCV(@RequestBody JobSeekerCV jobSeekerCV) {
		
		Result result = this.jobSeekerCVService.add(jobSeekerCV);
		
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		else {
			return ResponseEntity.badRequest().body(result);
		}
		
	}

	
}
