package hrms.humanResourcesManagementSystem.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.humanResourcesManagementSystem.business.abstracts.SystemPersonnelService;
import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.entities.concretes.SystemPersonnel;

@RestController
@RequestMapping("/api/systempersonnels/")
@CrossOrigin
public class SystemPersonnelsController {

	@Autowired
	private SystemPersonnelService systemPersonnelService;


	@GetMapping("getall")
	public ResponseEntity<?> getAll() {

		DataResult<List<SystemPersonnel>> dataResult = this.systemPersonnelService.getAll();

		if (dataResult.isSuccess()) {
			return ResponseEntity.ok(dataResult);
		}
		else {
			return ResponseEntity.badRequest().body(dataResult);
		}
	}

	@GetMapping("getbyid")
	public ResponseEntity<?> get(Integer id) {
		
		DataResult<SystemPersonnel> dataResult = this.systemPersonnelService.get(id);
		
		if (dataResult.isSuccess()) {
			return ResponseEntity.ok(dataResult);
		}
		else {
			return ResponseEntity.badRequest().body(dataResult);
		}
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
	public ResponseEntity<?> update(@RequestBody SystemPersonnel systemPersonnel) {
		
		Result result = this.systemPersonnelService.update(systemPersonnel);
		
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		} 
		else {
			return ResponseEntity.badRequest().body(result);
		}
	}
	
	@PostMapping("delete")
	public ResponseEntity<?> delete(Integer systemPersonnelId) {
		
		Result result = this.systemPersonnelService.delete(systemPersonnelId);
		
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		} 
		else {
			return ResponseEntity.badRequest().body(result);
		}
	}


}
