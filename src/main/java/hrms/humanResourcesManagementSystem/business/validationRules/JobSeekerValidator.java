package hrms.humanResourcesManagementSystem.business.validationRules;

import org.springframework.stereotype.Component;

import com.google.common.base.Strings;

import hrms.humanResourcesManagementSystem.business.abstracts.UserValidationService;
import hrms.humanResourcesManagementSystem.core.utilities.ErrorResult;
import hrms.humanResourcesManagementSystem.core.utilities.Result;
import hrms.humanResourcesManagementSystem.core.utilities.SuccessResult;
import hrms.humanResourcesManagementSystem.entities.JobSeeker;

@Component("JobSeekerV")
public class JobSeekerValidator implements UserValidationService<JobSeeker> {
	
	
	@Override
	public Result validate(JobSeeker jobSeeker) {	

		if ( Strings.isNullOrEmpty(jobSeeker.getFirstName()) || Strings.isNullOrEmpty(jobSeeker.getLastName())
				|| Strings.isNullOrEmpty(jobSeeker.getEmailAddress()) || Strings.isNullOrEmpty(jobSeeker.getPassword())
				|| jobSeeker.getBirthDate() == null ) {
			
				
				return new ErrorResult("İş arayının tüm alanları zorunludur.");
		}
		
		if ( Strings.isNullOrEmpty(jobSeeker.getFirstName().trim()) || Strings.isNullOrEmpty(jobSeeker.getLastName().trim())
				|| Strings.isNullOrEmpty(jobSeeker.getEmailAddress().trim()) || Strings.isNullOrEmpty(jobSeeker.getPassword().trim()) ) {
			
				return new ErrorResult("İş arayının tüm alanları zorunludur, alanlara sadece boşluk karakteri de girilemez.");
		}
		
		
//		if ( (jobSeeker.getFirstName() == null || jobSeeker.getFirstName().isBlank())
//			|| (jobSeeker.getLastName() == null || jobSeeker.getLastName().isBlank())
//			|| (jobSeeker.getEmailAddress() == null || jobSeeker.getEmailAddress().isBlank())
//			|| (jobSeeker.getPassword() == null || jobSeeker.getPassword().isBlank())
//			|| (jobSeeker.getNationalIdNo() == null || jobSeeker.getNationalIdNo().isBlank())
//			|| (jobSeeker.getBirthDate() == null) ) {
//		
//				return false;
//		}
		
		
		
			return new SuccessResult();
		
		}
	
	
}
