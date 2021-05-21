package hrms.humanResourcesManagementSystem.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.humanResourcesManagementSystem.entities.SystemPersonnel;

public interface SystemPersonnelDao extends JpaRepository<SystemPersonnel, Integer>{
	
}
