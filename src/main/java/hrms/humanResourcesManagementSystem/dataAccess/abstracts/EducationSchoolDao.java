package hrms.humanResourcesManagementSystem.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.humanResourcesManagementSystem.entities.concretes.EducationSchool;

public interface EducationSchoolDao extends JpaRepository<EducationSchool, Integer>{
	
	
	
}
