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
	public DataResult<List<JobAdvertDto>> getJobAdvertDtosByActiveTrue(){
		return this.jobAdvertService.getJobAdvertDtosByActiveTrue();
	}

	@GetMapping("getJobAdvertDtosByPublishedDateTimeAndActiveTrue")
	DataResult<List<JobAdvertDto>> getJobAdvertDtosByPublishedDateTimeAndActiveTrue(){
		return this.jobAdvertService.getJobAdvertDtosByPublishedDateTimeAndActiveTrue();
	}
	
	@GetMapping("getJobAdvertDtosByEmployerIdAndActiveTrue")
	DataResult<List<JobAdvertDto>> getJobAdvertDtosByEmployerIdAndActiveTrue(int employerId){
		return this.jobAdvertService.getJobAdvertDtosByEmployerIdAndActiveTrue(employerId);
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
	
	@PostMapping("addjobadvertdto")
	public ResponseEntity<?> addJobAdvert(@RequestBody JobAdvertAddDto jobAdvertAddDto) {
		
		JobAdvert jobAdvert = new JobAdvert(jobAdvertAddDto.getCityId(), jobAdvertAddDto.getJobTitleId(), 
				jobAdvertAddDto.getEmployerId(), jobAdvertAddDto.getJobDefinition(),
				jobAdvertAddDto.getMinSalary(), jobAdvertAddDto.getMaxSalary(),
				jobAdvertAddDto.getNumberOfOpenPositions(), jobAdvertAddDto.getDeadLineForAppeal());
		
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
