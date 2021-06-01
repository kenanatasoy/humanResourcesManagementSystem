package hrms.humanResourcesManagementSystem.entities.concretes;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import hrms.humanResourcesManagementSystem.core.entities.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "employers")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdverts"})
public class Employer extends User {
	
	@NotNull
	@NotBlank
	@Column(name = "company_name")
	private String companyName;
	
//	TODO: Anostasyonlar ile custom validation konusunu öğrenince işverenin web sitesi ile
//	aynı domain'e sahip e-posta girmesi koşulunu yazıcağız
	
	@NotNull
	@NotBlank
	@Column(name = "company_web_site")
	private String webSite;
	
	@NotNull
	@NotBlank
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@OneToMany(mappedBy = "employer")
	private List<JobAdvert> jobAdverts;
	
//	@Setter(AccessLevel.NONE)
//	private String calcPhoneNumber;
	
}
