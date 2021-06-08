package hrms.humanResourcesManagementSystem.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.humanResourcesManagementSystem.business.abstracts.EducationFacultyService;
import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.entities.concretes.EducationFaculty;

@RestController
@RequestMapping("/api/educationfaculties/")
public class EducationFacultiesController {
	
	@Autowired
	private EducationFacultyService educationFacultyService;
	
	
	@GetMapping("getall")
	public ResponseEntity<?> getAll(){
		
		DataResult<List<EducationFaculty>> dataResult = this.educationFacultyService.getAll();
		
		if (dataResult.isSuccess()) {
			return ResponseEntity.ok(dataResult);
		}
		else {
			return ResponseEntity.badRequest().body(dataResult);
		}
	}
	
	@GetMapping("getAllByUniverstyIdAndActiveTrue")
	public ResponseEntity<?> getAllByUniverstyIdAndActiveTrue(int schoolId){
		
		DataResult<List<EducationFaculty>> dataResult = this.educationFacultyService
				.getAllByUniverstyIdAndActiveTrue(schoolId);
		
		if (dataResult.isSuccess()) {
			return ResponseEntity.ok(dataResult);
		}
		else {
			return ResponseEntity.badRequest().body(dataResult);
		}
	}
	
	@GetMapping("getbyid")
	public ResponseEntity<?> get(int id) {
		
		DataResult<EducationFaculty> dataResult = this.educationFacultyService.get(id);
		
		if (dataResult.isSuccess()) {
			return ResponseEntity.ok(dataResult);
		}
		else {
			return ResponseEntity.badRequest().body(dataResult);
		}
		
	}
}
