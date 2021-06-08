package hrms.humanResourcesManagementSystem.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.humanResourcesManagementSystem.entities.concretes.EducationStudyField;

public interface EducationStudyFieldDao extends JpaRepository<EducationStudyField, Integer>{
	
	List<EducationStudyField> getByFacultyIdAndActiveTrue(int facultyId);
	
}
