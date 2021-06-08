package hrms.humanResourcesManagementSystem.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.humanResourcesManagementSystem.entities.concretes.EducationDegree;

public interface EducationDegreeDao extends JpaRepository<EducationDegree, Integer> {

}
