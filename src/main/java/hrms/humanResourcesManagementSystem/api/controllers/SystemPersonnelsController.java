package hrms.humanResourcesManagementSystem.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.humanResourcesManagementSystem.business.abstracts.SystemPersonnelService;
import hrms.humanResourcesManagementSystem.entities.SystemPersonnel;

@RestController
@RequestMapping("/api/systempersonnels/")
public class SystemPersonnelsController {

	@Autowired
	private SystemPersonnelService systemPersonnelService;
	
	
	@GetMapping("getall")
	public List<SystemPersonnel> getAll(){
		return this.systemPersonnelService.getAll();
	}
	
	@GetMapping("getbyid")
	public SystemPersonnel get(int id) {
		return this.systemPersonnelService.get(id);
	}
	
	@GetMapping("delete")
	public void delete(SystemPersonnel systemPersonnel) {
		this.systemPersonnelService.delete(systemPersonnel);
	}
	
	@GetMapping("add")
	public void add(SystemPersonnel systemPersonnel) {
		this.systemPersonnelService.add(systemPersonnel);
	}
	
	@GetMapping("update")
	public void update(SystemPersonnel systemPersonnel){
		this.systemPersonnelService.update(systemPersonnel);
	}
	
}

