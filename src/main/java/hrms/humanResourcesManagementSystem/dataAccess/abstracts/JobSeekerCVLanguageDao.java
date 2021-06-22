package hrms.humanResourcesManagementSystem.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hrms.humanResourcesManagementSystem.entities.concretes.JobSeekerCVLanguage;
import hrms.humanResourcesManagementSystem.entities.dtos.JobSeekerCVLanguageGetDto;

public interface JobSeekerCVLanguageDao extends JpaRepository<JobSeekerCVLanguage, Integer> {
	@Query("select new hrms.humanResourcesManagementSystem.entities.dtos.JobSeekerCVLanguageGetDto"
            + "(jSCVL.id, l.language, lP.proficiency)"
            + " from JobSeekerCVLanguage jSCVL"
            + " inner join Language l on l.id=jSCVL.languageId"
            + " inner join LanguageProficiency lP on lP.id=jSCVL.proficiencyId")
	List<JobSeekerCVLanguageGetDto> getJobSeekerCVLanguagesGetDtos();
	
	@Query("select new hrms.humanResourcesManagementSystem.entities.dtos.JobSeekerCVLanguageGetDto"
            + "(jSCVL.id, l.language, lP.proficiency)"
            + " from JobSeekerCVLanguage jSCVL"
            + " inner join Language l on l.id=jSCVL.languageId"
            + " inner join LanguageProficiency lP on lP.id=jSCVL.proficiencyId"
            + " where jSCVL.id=:jobSeekerCVLanguageId")
	JobSeekerCVLanguageGetDto getJobSeekerCVLanguagesGetDtoById(Integer jobSeekerCVLanguageId);
	
}
