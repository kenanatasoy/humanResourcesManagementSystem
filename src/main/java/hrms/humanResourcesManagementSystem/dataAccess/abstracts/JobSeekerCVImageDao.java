package hrms.humanResourcesManagementSystem.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.humanResourcesManagementSystem.entities.concretes.JobSeekerCVImage;

public interface JobSeekerCVImageDao extends JpaRepository<JobSeekerCVImage, Integer>{

}
