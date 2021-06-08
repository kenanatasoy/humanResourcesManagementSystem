package hrms.humanResourcesManagementSystem.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.humanResourcesManagementSystem.entities.concretes.JobSeekerCVLanguage;

public interface JobSeekerCVLanguageDao extends JpaRepository<JobSeekerCVLanguage, Integer> {

}
