package hrms.humanResourcesManagementSystem.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.humanResourcesManagementSystem.entities.SystemPersonnelConfirm;

public interface SystemPersonnelConfirmDao extends JpaRepository<SystemPersonnelConfirm, Integer> {

}
