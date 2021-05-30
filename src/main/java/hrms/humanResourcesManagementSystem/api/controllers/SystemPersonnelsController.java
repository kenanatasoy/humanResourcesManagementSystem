package hrms.humanResourcesManagementSystem.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.humanResourcesManagementSystem.business.abstracts.SystemPersonnelService;
import hrms.humanResourcesManagementSystem.core.utilities.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.Result;
import hrms.humanResourcesManagementSystem.entities.concretes.SystemPersonnel;

@RestController
@RequestMapping("/api/systempersonnels/")
public class SystemPersonnelsController {

	@Autowired
	private SystemPersonnelService systemPersonnelService;
	
	
	@GetMapping("getall")
	public DataResult<List<SystemPersonnel>> getAll(){
		return this.systemPersonnelService.getAll();
	}
	
	@GetMapping("getbyid")
	public DataResult<SystemPersonnel> get(int id) {
		return this.systemPersonnelService.get(id);
	}
	
	@PostMapping("delete")
	public Result delete(int systemPersonnelId) {
		return this.systemPersonnelService.delete(systemPersonnelId);
	}
	
	@PostMapping("add")
	public ResponseEntity<?> add(@RequestBody SystemPersonnel systemPersonnel) {
		
		Result result = this.systemPersonnelService.add(systemPersonnel);
		
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		else {
			return ResponseEntity.badRequest().body(result);
		}
		
	}
	
	@PostMapping("update")
	public Result update(SystemPersonnel systemPersonnel){
		return this.systemPersonnelService.update(systemPersonnel);
	}
	
	
	
}

