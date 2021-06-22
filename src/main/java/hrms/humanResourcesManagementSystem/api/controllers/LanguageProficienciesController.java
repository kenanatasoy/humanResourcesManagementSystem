package hrms.humanResourcesManagementSystem.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.humanResourcesManagementSystem.business.abstracts.LanguageProficiencyService;
import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.entities.concretes.LanguageProficiency;

@RestController
@RequestMapping("/api/languageproficiencies/")
@CrossOrigin
public class LanguageProficienciesController {

	@Autowired
	private LanguageProficiencyService languageProficiencyService;
	
	@GetMapping("getall")
	public ResponseEntity<?> getAll(){
		
		DataResult<List<LanguageProficiency>> dataResult = this.languageProficiencyService.getAll();
		
		if (dataResult.isSuccess()) {
			return ResponseEntity.ok(dataResult);
		}
		else {
			return ResponseEntity.badRequest().body(dataResult);
		}
	}
	
	@GetMapping("getbyid")
	public ResponseEntity<?> get(Integer id) {
		
		DataResult<LanguageProficiency> dataResult = this.languageProficiencyService.get(id);
		
		if (dataResult.isSuccess()) {
			return ResponseEntity.ok(dataResult);
		}
		else {
			return ResponseEntity.badRequest().body(dataResult);
		}
	}
}
