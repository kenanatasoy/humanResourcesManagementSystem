package hrms.humanResourcesManagementSystem.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.humanResourcesManagementSystem.business.abstracts.EmployerService;
import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.entities.concretes.Employer;

@RestController
@RequestMapping("/api/employers/")
public class EmployersController {

	@Autowired
	private EmployerService employerService;
	
	
	@GetMapping("getall")
	public ResponseEntity<?> getAll(){
		
		DataResult<List<Employer>> dataResult = this.employerService.getAll();
		
		if (dataResult.isSuccess()) {
			return ResponseEntity.ok(dataResult);
		}
		else {
			return ResponseEntity.badRequest().body(dataResult);
		}
	}
	
	@GetMapping("getbyid")
	public ResponseEntity<?> get(int id) {
		
		DataResult<Employer> dataResult = this.employerService.get(id);
		
		if (dataResult.isSuccess()) {
			return ResponseEntity.ok(dataResult);
		}
		else {
			return ResponseEntity.badRequest().body(dataResult);
		}
		
	}
	
//	@PostMapping("add")
//	public ResponseEntity<?> add(@RequestBody Employer employer){
//		
//		Result result = this.employerService.add(jobSeeker);
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

