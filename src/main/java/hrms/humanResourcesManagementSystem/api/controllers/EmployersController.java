package hrms.humanResourcesManagementSystem.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.humanResourcesManagementSystem.business.abstracts.EmployerService;
import hrms.humanResourcesManagementSystem.core.utilities.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.Result;
import hrms.humanResourcesManagementSystem.entities.concretes.Employer;

@RestController
@RequestMapping("/api/employers/")
public class EmployersController {

	@Autowired
	private EmployerService employerService;
	
	@GetMapping("getall")
	public DataResult<List<Employer>> getAll(){
		return this.employerService.getAll();
	}
	
	@GetMapping("getbyid")
	public DataResult<Employer> get(int id) {
		return this.employerService.get(id);
	}
	
	@PostMapping("delete")
	public Result delete(Employer employer) {
		return this.employerService.delete(employer);
	}
	
//	@PostMapping("add")
//	public ResponseEntity<?> add(@RequestBody Employer employer) {
//		
//		Result result = this.employerService.add(employer);
//		
//		if (result.isSuccess()) {
//			return ResponseEntity.ok(result);
//		}
//		else {
//			return ResponseEntity.badRequest().body(result);
//		}
//	}
	
	@PostMapping("update")
	public Result update(Employer employer){
		return this.employerService.update(employer);
	}
	
	
}

