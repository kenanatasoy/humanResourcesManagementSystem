package hrms.humanResourcesManagementSystem.business.validationRules;

import org.springframework.stereotype.Component;

import hrms.humanResourcesManagementSystem.business.abstracts.UserValidationService;
import hrms.humanResourcesManagementSystem.core.RegexEmailChecker;
import hrms.humanResourcesManagementSystem.core.utilities.results.ErrorResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessResult;
import hrms.humanResourcesManagementSystem.entities.concretes.Employer;

@Component("EmployerV")
public class EmployerValidator implements UserValidationService<Employer> {
	
	@Override
	public Result validate(Employer employer) {
		
		
		if (!RegexEmailChecker.match(employer.getEmailAddress())) {
			return new ErrorResult("E-posta, e-posta formatında olmalıdır.");
		}
		
		
		String[] splitStringArr1 = employer.getEmailAddress().split("@");
		String[] splitStringArr2 = employer.getWebSite().split("\\.");
	
		// TODO: Buralar iş koduna çevrilecek
		
		if( !splitStringArr1[1].equals(splitStringArr2[1] + "." + splitStringArr2[2]) ) {
			return new ErrorResult("E-posta domain'i ile web sitesi domain'i aynı olmalıdır.");
		}
		
		
		System.out.println(splitStringArr1[0] + " " + splitStringArr1[1]);
		
		System.out.println(splitStringArr2[0] + " " + splitStringArr2[1] + " " + splitStringArr2[2]);		
		
		System.out.println(String.format("%s %s", splitStringArr1[0], splitStringArr1[1]));
		
		return new SuccessResult();
		
	}

	
	
}
