package hrms.humanResourcesManagementSystem.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.humanResourcesManagementSystem.entities.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer> {
	
}
