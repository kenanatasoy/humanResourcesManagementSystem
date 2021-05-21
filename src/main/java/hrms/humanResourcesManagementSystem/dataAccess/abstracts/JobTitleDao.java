package hrms.humanResourcesManagementSystem.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.humanResourcesManagementSystem.entities.JobTitle;

public interface JobTitleDao extends JpaRepository<JobTitle, Integer>{

}
