package hrms.humanResourcesManagementSystem.entities.concretes;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "job_seeker_cv_langugages")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class JobSeekerCVLanguage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "job_seeker_CV_id")
	private Integer jobSeekerCVId;
	
	@Column(name = "language_id")
	private Integer languageId;
	
	@Column(name = "proficiency_id")
	private Integer proficiencyId;
	
	@Column(name = "added_date_time")
	private LocalDateTime addedDateTime = LocalDateTime.now();
	
//	@JsonIgnore
//	@ManyToOne
//	@JoinColumn(name = "job_seeker_cv_id")
//	private JobSeekerCV jobSeekerCV;
	
}
