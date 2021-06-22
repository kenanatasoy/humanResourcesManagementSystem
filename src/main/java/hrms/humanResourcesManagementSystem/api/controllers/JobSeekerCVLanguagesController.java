package hrms.humanResourcesManagementSystem.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.humanResourcesManagementSystem.business.abstracts.JobSeekerCVLanguageService;
import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.entities.concretes.JobSeekerCVLanguage;
import hrms.humanResourcesManagementSystem.entities.dtos.JobSeekerCVLanguageGetDto;

@RestController
@RequestMapping("/api/jobseekercvlanguages/")
@CrossOrigin
public class JobSeekerCVLanguagesController {

	@Autowired
	private JobSeekerCVLanguageService jobSeekerCVLanguageService;
	
	
	@GetMapping("getJobSeekerCVLanguagesGetDtos")
	public ResponseEntity<?> getJobSeekerCVLanguagesGetDtos(){
		
		DataResult<List<JobSeekerCVLanguageGetDto>> dataResult = 
				this.jobSeekerCVLanguageService.getJobSeekerCVLanguagesGetDtos();
		
		if (dataResult.isSuccess()) {
			return ResponseEntity.ok(dataResult);
		}
		else {
			return ResponseEntity.badRequest().body(dataResult);
		}
	}
	
	@GetMapping("getJobSeekerCVLanguagesGetDtoById")
	public ResponseEntity<?> getJobSeekerCVLanguagesGetDtoById(Integer id) {
		
		DataResult<JobSeekerCVLanguageGetDto> dataResult = 
				this.jobSeekerCVLanguageService.getJobSeekerCVLanguagesGetDtoById(id);
		
		if (dataResult.isSuccess()) {
			return ResponseEntity.ok(dataResult);
		}
		else {
			return ResponseEntity.badRequest().body(dataResult);
		}
		
	}
	
	@PostMapping("add")
	public ResponseEntity<?> add(@RequestBody JobSeekerCVLanguage jobSeekerCVLanguage){
		
		Result result = this.jobSeekerCVLanguageService.add(jobSeekerCVLanguage);
		
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		else {
			return ResponseEntity.badRequest().body(result);
		}
		
	}
	
	@DeleteMapping("deletebyid")
	public ResponseEntity<?> deleteById(Integer jobSeekerCVLanguageId){
		
		Result result = this.jobSeekerCVLanguageService.deleteById(jobSeekerCVLanguageId);
		
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		else {
			return ResponseEntity.badRequest().body(result);
		}
		
	}
	
	
}
