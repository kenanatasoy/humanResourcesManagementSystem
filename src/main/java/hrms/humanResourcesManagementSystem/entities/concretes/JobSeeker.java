package hrms.humanResourcesManagementSystem.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import hrms.humanResourcesManagementSystem.core.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "job_seekers")
public class JobSeeker extends User{
	
	@Column(name = "national_id_no", unique = true)
	private String nationalIdNo;
	
	@Column(name = "birth_date")
	private LocalDate birthDate;
	
	
}
