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

import hrms.humanResourcesManagementSystem.business.abstracts.JobAdvertService;
import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.entities.dtos.JobAdvertAddDto;
import hrms.humanResourcesManagementSystem.entities.dtos.JobAdvertGetDto;

@RestController
@RequestMapping("/api/jobadverts/")
@CrossOrigin
public class JobAdvertsController {

	@Autowired
	private JobAdvertService jobAdvertService;


	@GetMapping("getConfirmedJobAdvertDtosByActiveTrue")
	public ResponseEntity<?> getConfirmedJobAdvertDtosByActiveTrue() {
		
		DataResult<List<JobAdvertGetDto>> dataResult = this.jobAdvertService.getConfirmedJobAdvertDtosByActiveTrue();

		if (dataResult.isSuccess()) {
			return ResponseEntity.ok(dataResult);
		} 
		else {
			return ResponseEntity.badRequest().body(dataResult);
		}

	}

	@GetMapping("getConfirmedJobAdvertDtosByPublishedDateTimeAndActiveTrue")
	public ResponseEntity<?> getConfirmedJobAdvertDtosByPublishedDateTimeAndActiveTrue() {
		
		DataResult<List<JobAdvertGetDto>> dataResult = this.jobAdvertService.getConfirmedJobAdvertDtosByPublishedDateTimeAndActiveTrue();
		
		if (dataResult.isSuccess()) {
			return ResponseEntity.ok(dataResult);
		} 
		else {
			return ResponseEntity.badRequest().body(dataResult);
		}
		
	}

	@GetMapping("getConfirmedJobAdvertDtosByEmployerIdAndActiveTrue")
	public ResponseEntity<?> getConfirmedJobAdvertDtosByEmployerIdAndActiveTrue(Integer employerId) {
		
		DataResult<List<JobAdvertGetDto>> dataResult = this.jobAdvertService.getConfirmedJobAdvertDtosByEmployerIdAndActiveTrue(employerId);
	
		if (dataResult.isSuccess()) {
			return ResponseEntity.ok(dataResult);
		} 
		else {
			return ResponseEntity.badRequest().body(dataResult);
		}
	}
	
	@GetMapping("getConfirmedJobAdvertDtoByIdAndActiveTrue")
	public ResponseEntity<?> getConfirmedJobAdvertDtoByIdAndActiveTrue(Integer jobAdvertId) {
		
		DataResult<JobAdvertGetDto> dataResult = this.jobAdvertService.getConfirmedJobAdvertDtoByIdAndActiveTrue(jobAdvertId);
	
		if (dataResult.isSuccess()) {
			return ResponseEntity.ok(dataResult);
		} 
		else {
			return ResponseEntity.badRequest().body(dataResult);
		}
	}
	
//	@GetMapping("getAll")
//	public ResponseEntity<?> getAll() {
//
//		DataResult<List<JobAdvert>> dataResult = this.jobAdvertService.getAll();
//
//		if (dataResult.isSuccess()) {
//			return ResponseEntity.ok(dataResult);
//		} else {
//			return ResponseEntity.badRequest().body(dataResult);
//		}
//	}

	@PostMapping("addjobadvertdto")
	public ResponseEntity<?> addJobAdvert(@Valid @RequestBody JobAdvertAddDto jobAdvertAddDto) {

		Result result = this.jobAdvertService.add(jobAdvertAddDto);

		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		} else {
			return ResponseEntity.badRequest().body(result);
		}
		
	}

	@PostMapping("toggleJobAdvertActivePassive")
	public ResponseEntity<?> toggleJobAdActivePassive(Integer jobAdvertId, Boolean isActivated) {

		Result result = this.jobAdvertService.toggleJobAdActivePassive(jobAdvertId, isActivated);

		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		} else {
			return ResponseEntity.badRequest().body(result);
		}
		
		// TODO: Burası düzeltilecek
		
	}

}
