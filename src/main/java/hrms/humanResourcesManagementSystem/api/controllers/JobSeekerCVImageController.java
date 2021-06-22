package hrms.humanResourcesManagementSystem.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import hrms.humanResourcesManagementSystem.business.abstracts.JobSeekerCVImageService;
import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.entities.concretes.JobSeekerCVImage;

@RestController
@RequestMapping("/api/jobseekercvimages/")
@CrossOrigin
public class JobSeekerCVImageController {

	@Autowired
	private JobSeekerCVImageService jobSeekerCVImageService;


//	@GetMapping("getallimages")
//	public ResponseEntity<?> getAll(){
//		
//		DataResult<List<JobSeekerCVImage>> dataResult = this.jobSeekerCVImageService.getAll();
//		
//		if (dataResult.isSuccess()) {
//			return ResponseEntity.ok(dataResult);
//		}
//		else {
//			return ResponseEntity.badRequest().body(dataResult);
//		}
//		
//	}
	
	@GetMapping("getbyid")
	public ResponseEntity<?> get(Integer id) {
		
		DataResult<JobSeekerCVImage> dataResult = this.jobSeekerCVImageService.get(id);
		
		if (dataResult.isSuccess()) {
			return ResponseEntity.ok(dataResult);
		}
		else {
			return ResponseEntity.badRequest().body(dataResult);
		}
		
	}
	
	@PostMapping("uploadimage")
	public ResponseEntity<?> add(@RequestBody MultipartFile multipartFile, Integer jobSeekerCVId) {
		
		Result result = this.jobSeekerCVImageService.saveImage(multipartFile, jobSeekerCVId);
		
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		else {
			return ResponseEntity.badRequest().body(result);
		}
		
	}
	
	
}

