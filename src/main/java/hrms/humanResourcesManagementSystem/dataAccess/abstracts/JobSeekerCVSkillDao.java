package hrms.humanResourcesManagementSystem.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.humanResourcesManagementSystem.entities.concretes.JobSeekerCVSkill;

public interface JobSeekerCVSkillDao extends JpaRepository<JobSeekerCVSkill, Integer> {

}
