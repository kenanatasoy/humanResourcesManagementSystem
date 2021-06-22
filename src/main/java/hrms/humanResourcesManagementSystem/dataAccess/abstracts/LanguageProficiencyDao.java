package hrms.humanResourcesManagementSystem.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.humanResourcesManagementSystem.entities.concretes.LanguageProficiency;

public interface LanguageProficiencyDao extends JpaRepository<LanguageProficiency, Integer> {

}
