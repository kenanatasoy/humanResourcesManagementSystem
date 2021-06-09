package hrms.humanResourcesManagementSystem.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.humanResourcesManagementSystem.entities.concretes.JobSeekerCV;

public interface JobSeekerCVDao extends JpaRepository<JobSeekerCV, Integer> {

	List<JobSeekerCV> getByJobSeekerId(int jobSeekerId);
	
}
