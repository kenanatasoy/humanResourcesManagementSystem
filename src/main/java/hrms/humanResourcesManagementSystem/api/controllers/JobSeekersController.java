package hrms.humanResourcesManagementSystem.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.humanResourcesManagementSystem.business.abstracts.JobSeekerService;
import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.entities.concretes.JobSeeker;

@RestController
@RequestMapping("/api/jobseekers/")
@CrossOrigin
public class JobSeekersController {

	@Autowired
	private JobSeekerService jobSeekerService;
	
	
	@GetMapping("getall")
	public ResponseEntity<?> getAll(){
		
		DataResult<List<JobSeeker>> dataResult = this.jobSeekerService.getAll();
		
		if (dataResult.isSuccess()) {
			return ResponseEntity.ok(dataResult);
		}
		else {
			return ResponseEntity.badRequest().body(dataResult);
		}
		
	}
	
	@GetMapping("getbyid")
	public ResponseEntity<?> get(Integer id) {
		
		DataResult<JobSeeker> dataResult = this.jobSeekerService.get(id);
		
		if (dataResult.isSuccess()) {
			return ResponseEntity.ok(dataResult);
		}
		else {
			return ResponseEntity.badRequest().body(dataResult);
		}
		
	}
	
//	@PostMapping("add")
//	public ResponseEntity<?> add(@RequestBody JobSeeker jobSeeker) throws RemoteException{
//		
//		Result result = this.jobSeekerService.add(jobSeeker);
//		
//		
//		if (result.isSuccess()) {
//			return ResponseEntity.ok(result);
//		}
//		else {
//			return ResponseEntity.badRequest().body(result);
//		}
//		
//	}
	
//	@PostMapping("update")
//	public ResponseEntity<?> update(@RequestBody JobSeeker jobSeeker){
//		
//		Result result = this.jobSeekerService.update(jobSeeker);
//		
//		if (result.isSuccess()) {
//			return ResponseEntity.ok(result);
//		}
//		else {
//			return ResponseEntity.badRequest().body(result);
//		}
//		
//	}
	
	
	
}

