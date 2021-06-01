package hrms.humanResourcesManagementSystem.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import hrms.humanResourcesManagementSystem.core.entities.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "job_seekers")
public class JobSeeker extends User{
	
	@NotNull
	@NotBlank
	@Column(name = "national_id_no", unique = true)
	private String nationalIdNo;
	
	@NotNull
	@NotBlank
	@Column(name = "birth_date")
	private LocalDate birthDate;
	
	
}
