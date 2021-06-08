package hrms.humanResourcesManagementSystem.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.humanResourcesManagementSystem.entities.concretes.JobSeekerCV;

public interface JobSeekerCVDao extends JpaRepository<JobSeekerCV, Integer> {

}
