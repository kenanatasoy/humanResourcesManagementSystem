package hrms.humanResourcesManagementSystem.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.humanResourcesManagementSystem.business.abstracts.LanguageService;
import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.entities.concretes.Language;

@RestController
@RequestMapping("/api/languages/")
@CrossOrigin
public class LanguagesController {

	@Autowired
	private LanguageService languageService;
	
	@GetMapping("getall")
	public ResponseEntity<?> getAll(){
		
		DataResult<List<Language>> dataResult = this.languageService.getAll();
		
		if (dataResult.isSuccess()) {
			return ResponseEntity.ok(dataResult);
		}
		else {
			return ResponseEntity.badRequest().body(dataResult);
		}
	}
	
	@GetMapping("getbyid")
	public ResponseEntity<?> get(Integer id) {
		
		DataResult<Language> dataResult = this.languageService.get(id);
		
		if (dataResult.isSuccess()) {
			return ResponseEntity.ok(dataResult);
		}
		else {
			return ResponseEntity.badRequest().body(dataResult);
		}
	}
	
}
