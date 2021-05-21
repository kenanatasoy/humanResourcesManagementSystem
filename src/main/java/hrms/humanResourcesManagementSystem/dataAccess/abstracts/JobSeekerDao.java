package hrms.humanResourcesManagementSystem.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.humanResourcesManagementSystem.entities.JobSeeker;


public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer> {

}
