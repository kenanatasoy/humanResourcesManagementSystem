package hrms.humanResourcesManagementSystem.business.validationRules;

import org.springframework.stereotype.Component;

import com.google.common.base.Strings;

import hrms.humanResourcesManagementSystem.business.abstracts.UserValidationService;
import hrms.humanResourcesManagementSystem.core.RegexEmailChecker;
import hrms.humanResourcesManagementSystem.core.utilities.ErrorResult;
import hrms.humanResourcesManagementSystem.core.utilities.Result;
import hrms.humanResourcesManagementSystem.core.utilities.SuccessResult;
import hrms.humanResourcesManagementSystem.entities.Employer;

@Component("EmployerV")
public class EmployerValidator implements UserValidationService<Employer> {
	
	@Override
	public Result validate(Employer employer) {
		
		
		if ( Strings.isNullOrEmpty(employer.getFirstName()) || Strings.isNullOrEmpty(employer.getLastName())
				|| Strings.isNullOrEmpty(employer.getEmailAddress()) || Strings.isNullOrEmpty(employer.getPassword()) 
				|| Strings.isNullOrEmpty(employer.getCompanyName()) || Strings.isNullOrEmpty(employer.getWebSite())
				|| Strings.isNullOrEmpty(employer.getPhoneNumber()) ) {
			
			return new ErrorResult("Tüm alanlar zorunludur.");
		}
		
		
		if ( Strings.isNullOrEmpty(employer.getFirstName().trim()) || Strings.isNullOrEmpty(employer.getLastName().trim())
				|| Strings.isNullOrEmpty(employer.getEmailAddress().trim()) || Strings.isNullOrEmpty(employer.getPassword().trim()) 
				|| Strings.isNullOrEmpty(employer.getCompanyName().trim()) || Strings.isNullOrEmpty(employer.getWebSite().trim())
				|| Strings.isNullOrEmpty(employer.getPhoneNumber().trim()) ) {
				
			return new ErrorResult("Tüm alanlar zorunludur, sadece boşluk karakteri de girilemez");
		}
		
		
		if (!RegexEmailChecker.match(employer.getEmailAddress())) {
			return new ErrorResult("E-posta, e-posta formatında olmalıdır.");
		}
		
		
		String[] splitStringArr1 = employer.getEmailAddress().split("@");
		String[] splitStringArr2 = employer.getWebSite().split(".");
		
		
		if( !splitStringArr1[1].equals(splitStringArr2[1] + "." + splitStringArr2[2]) ) {
			return new ErrorResult("E-posta domain'i ile web sitesi domain'i aynı olmalıdır.");
		}
		
		
		return new SuccessResult();
		
	}

	
	
}
