package hrms.humanResourcesManagementSystem.dataAccess.abstracts;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.humanResourcesManagementSystem.entities.concretes.SystemPersonnelConfirmOfJobAdvert;

public interface SystemPersonnelConfirmOfJobAdvertDao extends JpaRepository<SystemPersonnelConfirmOfJobAdvert, Integer>{

	Optional<SystemPersonnelConfirmOfJobAdvert> findByJobAdvertId(int jobAdvertId);
	
}
