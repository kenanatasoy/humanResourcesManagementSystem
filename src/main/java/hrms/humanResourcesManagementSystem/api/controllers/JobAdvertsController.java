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
import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.entities.concretes.JobAdvert;
import hrms.humanResourcesManagementSystem.entities.dtos.JobAdvertAddDto;
import hrms.humanResourcesManagementSystem.entities.dtos.JobAdvertDto;

@RestController
@RequestMapping("/api/jobadverts/")
public class JobAdvertsController {

	@Autowired
	private JobAdvertService jobAdvertService;


	@GetMapping("getJobAdvertDtosByActiveTrue")
	public ResponseEntity<?> getJobAdvertDtosByActiveTrue() {
		
		DataResult<List<JobAdvertDto>> dataResult = this.jobAdvertService.getJobAdvertDtosByActiveTrue();

		if (dataResult.isSuccess()) {
			return ResponseEntity.ok(dataResult);
		} 
		else {
			return ResponseEntity.badRequest().body(dataResult);
		}

	}

	@GetMapping("getJobAdvertDtosByPublishedDateTimeAndActiveTrue")
	public ResponseEntity<?> getJobAdvertDtosByPublishedDateTimeAndActiveTrue() {
		
		DataResult<List<JobAdvertDto>> dataResult = this.jobAdvertService.getJobAdvertDtosByPublishedDateTimeAndActiveTrue();
		
		if (dataResult.isSuccess()) {
			return ResponseEntity.ok(dataResult);
		} 
		else {
			return ResponseEntity.badRequest().body(dataResult);
		}
		
	}

	@GetMapping("getJobAdvertDtosByEmployerIdAndActiveTrue")
	public ResponseEntity<?> getJobAdvertDtosByEmployerIdAndActiveTrue(int employerId) {
		
		DataResult<List<JobAdvertDto>> dataResult = this.jobAdvertService.getJobAdvertDtosByEmployerIdAndActiveTrue(employerId);
	
		if (dataResult.isSuccess()) {
			return ResponseEntity.ok(dataResult);
		} 
		else {
			return ResponseEntity.badRequest().body(dataResult);
		}
	}

	@GetMapping("getAll")
	public ResponseEntity<?> getAll() {

		DataResult<List<JobAdvert>> dataResult = this.jobAdvertService.getAll();

		if (dataResult.isSuccess()) {
			return ResponseEntity.ok(dataResult);
		} else {
			return ResponseEntity.badRequest().body(dataResult);
		}
	}

	@PostMapping("addjobadvertdto")
	public ResponseEntity<?> addJobAdvert(@RequestBody JobAdvertAddDto jobAdvertAddDto) {

		Result result = this.jobAdvertService.add(jobAdvertAddDto);

		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		} else {
			return ResponseEntity.badRequest().body(result);
		}
		
	}

	@PostMapping("toggleJobAdActivePassive")
	public ResponseEntity<?> toggleJobAdActivePassive(int jobAdvertId) {

		Result result = this.jobAdvertService.toggleJobAdActivePassive(jobAdvertId);

		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		} else {
			return ResponseEntity.badRequest().body(result);
		}
		
	}

}
