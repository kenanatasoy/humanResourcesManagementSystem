package hrms.humanResourcesManagementSystem.entities.concretes;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import hrms.humanResourcesManagementSystem.core.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "employers")
//@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdverts"})
public class Employer extends User {
	
	@Column(name = "company_name")
	private String companyName;
	
	@Column(name = "company_web_site")
	private String webSite;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
//	@OneToMany(mappedBy = "employer")
//	private List<JobAdvert> jobAdverts;
	
//	@Setter(AccessLevel.NONE)
//	private String calcPhoneNumber;
	
}
