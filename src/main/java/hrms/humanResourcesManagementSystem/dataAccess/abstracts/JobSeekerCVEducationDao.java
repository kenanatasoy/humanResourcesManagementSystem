package hrms.humanResourcesManagementSystem.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.humanResourcesManagementSystem.entities.concretes.JobSeekerCVEducation;

public interface JobSeekerCVEducationDao extends JpaRepository<JobSeekerCVEducation, Integer>{

	List<JobSeekerCVEducation> findAllByJobSeekerCV_IdOrderByGraduationDateDesc(int jobSeekerCVId);
	
}



