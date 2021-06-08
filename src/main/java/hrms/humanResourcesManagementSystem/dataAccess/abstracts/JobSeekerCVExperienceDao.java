package hrms.humanResourcesManagementSystem.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.humanResourcesManagementSystem.entities.concretes.JobSeekerCVExperience;

public interface JobSeekerCVExperienceDao extends JpaRepository<JobSeekerCVExperience, Integer>{
	
	List<JobSeekerCVExperience> findAllByJobSeekerCVIdOrderByEndingDateDesc(int jobSeekerCVId);

}
