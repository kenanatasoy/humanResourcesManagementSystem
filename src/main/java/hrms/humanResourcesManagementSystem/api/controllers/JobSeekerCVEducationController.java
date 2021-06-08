package hrms.humanResourcesManagementSystem.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.humanResourcesManagementSystem.business.abstracts.JobSeekerCVEducationService;
import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.entities.concretes.JobSeekerCVEducation;
import hrms.humanResourcesManagementSystem.entities.dtos.JobSeekerCVEducationAddDto;

@RestController
@RequestMapping("/api/jobseekercveducations/")
public class JobSeekerCVEducationController {

	@Autowired
	private JobSeekerCVEducationService jobSeekerCVEducationService;

	
	@GetMapping("getall")
	public ResponseEntity<?> getAll() {

		DataResult<List<JobSeekerCVEducation>> dataResult = this.jobSeekerCVEducationService.getAll();

		if (dataResult.isSuccess()) {
			return ResponseEntity.ok(dataResult);
		} else {
			return ResponseEntity.badRequest().body(dataResult);
		}

	}

	@GetMapping("getAllByJobSeekerCVIdOrderByGraduationDateDesc")
	public ResponseEntity<?> findAllByJobSeekerCVIdOrderByGraduationDateDesc(int jobSeekerCVId) {

		DataResult<List<JobSeekerCVEducation>> dataResult = this.jobSeekerCVEducationService
				.getAllByJobSeekerCVIdOrderByGraduationDateDesc(jobSeekerCVId);

		if (dataResult.isSuccess()) {
			return ResponseEntity.ok(dataResult);
		} 
		else {
			return ResponseEntity.badRequest().body(dataResult);
		}

	}

	@GetMapping("getbyid")
	public ResponseEntity<?> get(int id) {

		DataResult<JobSeekerCVEducation> dataResult = this.jobSeekerCVEducationService.get(id);

		if (dataResult.isSuccess()) {
			return ResponseEntity.ok(dataResult);
		} else {
			return ResponseEntity.badRequest().body(dataResult);
		}

	}

	@PostMapping("add")
	public ResponseEntity<?> add(@RequestBody JobSeekerCVEducationAddDto jobSeekerCVEducationAddDto) {

		Result result = this.jobSeekerCVEducationService.add(jobSeekerCVEducationAddDto);

		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		} else {
			return ResponseEntity.badRequest().body(result);
		}

	}

}
