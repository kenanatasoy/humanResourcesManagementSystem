package hrms.humanResourcesManagementSystem.dataAccess.abstracts;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.humanResourcesManagementSystem.entities.concretes.SystemPersonnelConfirmOfEmployer;

public interface SystemPersonnelConfirmOfEmployerDao extends JpaRepository<SystemPersonnelConfirmOfEmployer, Integer> {

	Optional<SystemPersonnelConfirmOfEmployer> findByEmployerId(int employerId);

}
