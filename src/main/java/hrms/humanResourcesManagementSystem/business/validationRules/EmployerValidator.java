package hrms.humanResourcesManagementSystem.business.validationRules;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import hrms.humanResourcesManagementSystem.business.abstracts.UserValidationService;
import hrms.humanResourcesManagementSystem.core.RegexUtil;
import hrms.humanResourcesManagementSystem.core.User;
import hrms.humanResourcesManagementSystem.entities.Employer;

@Component("EmployerV")
public class EmployerValidator implements UserValidationService<Employer> {
	
	@Override
	public boolean validate(Employer employer) {
		
		
		if (employer.getFirstName() == null && employer.getLastName() == null && employer.getCompanyName() == null
				&& employer.getWebSite() == null && employer.getEmailAddress() == null
				&& employer.getPhoneNumber() == null && employer.getPassword() == null) {
			
			System.out.println("Employer's name, surname, company name, web site, email, phone number "
					+ "and password are mandatory");
			
			return false;
		}
		
		
		// TODO: Burada e-postanın web sitesi ile aynı domain'e sahip olup olmadığı kontrol edilmelidir, henüz yapılmadı.
		if (!RegexUtil.match(employer.getEmailAddress())) {
			System.out.println("E-posta, e-posta formatında olmalıdır");
			return false;
		}
		
		return true;
		
		
	}

	
	
}
