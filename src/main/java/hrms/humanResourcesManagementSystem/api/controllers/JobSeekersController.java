package hrms.humanResourcesManagementSystem.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.humanResourcesManagementSystem.business.abstracts.JobSeekerService;
import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.ErrorResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.entities.concretes.JobSeeker;

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
	
	
	
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Object> handleJsonExceptions(HttpMessageNotReadableException ex) {
        if(ex.getMessage().contains("birthDate")){
            return new ResponseEntity<>(
                    new ErrorResult("Wrong birth date format. Pattern should be like 2015-05-20 (YYYY-mm-dd)"),
                    HttpStatus.NOT_ACCEPTABLE
            );
        }
        return new ResponseEntity<>(new ErrorResult(ex.getMessage()),
                HttpStatus.NOT_ACCEPTABLE);
    }
	
	
}

