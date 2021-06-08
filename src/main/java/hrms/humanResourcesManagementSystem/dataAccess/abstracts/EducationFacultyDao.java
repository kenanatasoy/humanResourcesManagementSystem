package hrms.humanResourcesManagementSystem.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.humanResourcesManagementSystem.entities.concretes.EducationFaculty;

public interface EducationFacultyDao extends JpaRepository<EducationFaculty, Integer>{

	List<EducationFaculty> getByUniversityIdAndActiveTrue(int schoolId);
	
}
