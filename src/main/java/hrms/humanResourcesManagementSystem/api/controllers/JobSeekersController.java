package hrms.humanResourcesManagementSystem.api.controllers;

import java.rmi.RemoteException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus.Series;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.humanResourcesManagementSystem.business.abstracts.JobSeekerService;
import hrms.humanResourcesManagementSystem.entities.JobSeeker;

@RestController
@RequestMapping("/api/jobseekers/")
public class JobSeekersController {

	@Autowired
	private JobSeekerService jobSeekerService;
	
	@GetMapping("getall")
	public List<JobSeeker> getAll(){
		return this.jobSeekerService.getAll();
	}
	
	@GetMapping("getbyid")
	public JobSeeker get(int id) {
		return this.jobSeekerService.get(id);
	}
	
	@GetMapping("delete")
	public void delete(JobSeeker jobSeeker) {
		this.jobSeekerService.delete(jobSeeker);
	}
	
	@PostMapping("add")
	public ResponseEntity<?> add(@RequestBody JobSeeker jobSeeker) throws RemoteException{
		if (this.jobSeekerService.add(jobSeeker)) {
			System.out.println("Add request is sent, and record is successfully added to the database");
		
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else {
			
			System.out.println("Add request is sent but record is not added to the database");
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping("update")
	public void update(JobSeeker jobSeeker){
		this.jobSeekerService.update(jobSeeker);
	}
	
}

