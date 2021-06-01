package hrms.humanResourcesManagementSystem.business.validationRules;

import org.springframework.stereotype.Component;

import hrms.humanResourcesManagementSystem.business.abstracts.UserValidationService;
import hrms.humanResourcesManagementSystem.core.RegexEmailChecker;
import hrms.humanResourcesManagementSystem.core.utilities.results.ErrorResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessResult;
import hrms.humanResourcesManagementSystem.entities.concretes.JobSeeker;

@Component("JobSeekerV")
public class JobSeekerValidator implements UserValidationService<JobSeeker> {
	
	
	@Override
	public Result validate(JobSeeker jobSeeker) {
		
		if (!RegexEmailChecker.match(jobSeeker.getEmailAddress())) {
			return new ErrorResult("E-posta, e-posta formatında olmalıdır.");
		}
		
			return new SuccessResult();
			
		}
	
	
}
