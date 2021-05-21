package hrms.humanResourcesManagementSystem.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.humanResourcesManagementSystem.business.abstracts.EmployerService;
import hrms.humanResourcesManagementSystem.entities.Employer;

@RestController
@RequestMapping("/api/users/")
public class EmployersController {

	@Autowired
	private EmployerService employerService;
	
	
	@GetMapping("getall")
	public List<Employer> getAll(){
		return this.employerService.getAll();
	}
	
	@GetMapping("getbyid")
	public Employer get(int id) {
		return this.employerService.get(id);
	}
	
	@GetMapping("delete")
	public void delete(Employer employer) {
		this.employerService.delete(employer);
	}
	
	@GetMapping("add")
	public void add(Employer employer) {
		this.employerService.add(employer);
	}
	
	@GetMapping("update")
	public void update(Employer employer){
		this.employerService.update(employer);
	}
	
}

