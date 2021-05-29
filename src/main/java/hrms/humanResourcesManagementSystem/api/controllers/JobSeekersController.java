package hrms.humanResourcesManagementSystem.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.humanResourcesManagementSystem.business.abstracts.JobSeekerService;
import hrms.humanResourcesManagementSystem.core.utilities.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.Result;
import hrms.humanResourcesManagementSystem.entities.JobSeeker;

@RestController
@RequestMapping("/api/jobseekers/")
public class JobSeekersController {

	@Autowired
	private JobSeekerService jobSeekerService;
	
	@GetMapping("getall")
	public DataResult<List<JobSeeker>> getAll(){
		return this.jobSeekerService.getAll();
	}
	
	@GetMapping("getbyid")
	public DataResult<JobSeeker> get(int id) {
		return this.jobSeekerService.get(id);
	}
	
	@PostMapping("delete")
	public Result delete(JobSeeker jobSeeker) {
		return this.jobSeekerService.delete(jobSeeker);
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
	
	@PostMapping("update")
	public Result update(JobSeeker jobSeeker){
		return this.jobSeekerService.update(jobSeeker);
	}
	
}

