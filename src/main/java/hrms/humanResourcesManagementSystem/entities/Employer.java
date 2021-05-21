package hrms.humanResourcesManagementSystem.entities;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Table;

import hrms.humanResourcesManagementSystem.core.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "employers")
public class Employer extends User {
	
	@Column(name = "company_name")
	private String companyName;
	
	@Column(name = "company_web_site")
	private String webSite;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
//	@Setter(AccessLevel.NONE)
//	private String calcPhoneNumber;
	
}
