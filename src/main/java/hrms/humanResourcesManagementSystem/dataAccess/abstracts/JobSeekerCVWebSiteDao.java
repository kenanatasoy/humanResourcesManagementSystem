package hrms.humanResourcesManagementSystem.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.humanResourcesManagementSystem.entities.concretes.JobSeekerCVWebSite;

public interface JobSeekerCVWebSiteDao extends JpaRepository<JobSeekerCVWebSite, Integer>{

}
