package hrms.humanResourcesManagementSystem.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.humanResourcesManagementSystem.business.abstracts.EducationStudyFieldService;
import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.entities.concretes.EducationStudyField;

@RestController
@RequestMapping("/api/educationstudyfields/")
public class EducationStudyFieldsController {

	@Autowired
	private EducationStudyFieldService educationStudyFieldService;
	
	
	@GetMapping("getall")
	public ResponseEntity<?> getAll(){
		
		DataResult<List<EducationStudyField>> dataResult = this.educationStudyFieldService.getAll();
		
		if (dataResult.isSuccess()) {
			return ResponseEntity.ok(dataResult);
		}
		else {
			return ResponseEntity.badRequest().body(dataResult);
		}
		
	}
	
	@GetMapping("getByFacultyIdAndActiveTrue")
	public ResponseEntity<?> getByFacultyIdAndActiveTrue(int facultyId) {
		
		DataResult<List<EducationStudyField>> dataResult = this.educationStudyFieldService
				.getByFacultyIdAndActiveTrue(facultyId);
	
		if (dataResult.isSuccess()) {
			return ResponseEntity.ok(dataResult);
		}
		else {
			return ResponseEntity.badRequest().body(dataResult);
		}
		
	}
	
	@GetMapping("getbyid")
	public ResponseEntity<?> get(int id) {
		
		DataResult<EducationStudyField> dataResult = this.educationStudyFieldService.get(id);
		
		if (dataResult.isSuccess()) {
			return ResponseEntity.ok(dataResult);
		}
		else {
			return ResponseEntity.badRequest().body(dataResult);
		}
		
	}
}
