package hrms.humanResourcesManagementSystem.business.validationRules;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import hrms.humanResourcesManagementSystem.business.abstracts.UserValidationService;
import hrms.humanResourcesManagementSystem.entities.JobSeeker;

@Component("JobSeekerV")
public class JobSeekerValidator implements UserValidationService<JobSeeker> {
	
	
	@Override
	public boolean validate(JobSeeker jobSeeker) {	

		if (jobSeeker.getFirstName().equals(null) && jobSeeker.getLastName().equals(null) && jobSeeker.getPassword().equals(null)
				&& jobSeeker.getEmailAddress().equals(null) && jobSeeker.getBirthDate().equals(null)
				&& jobSeeker.getNationalIdNo().equals(null)) {
			
			// TODO: kod tarafında doğum tarihi(LocalDate) yerine doğum yılı(int) kontrol edilecek, henüz yapılmadı.
			
			System.out.println("JobSeeker's name, surname, email, password, nationalId and birthDate are mandatory");
			
			return false;
		}	
		
		return true;
	}
	
	


}
