package hrms.humanResourcesManagementSystem.entities.concretes;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "job_seeker_cv_skills")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class JobSeekerCVSkill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
//	@Column(name = "job_seeker_CV_id")
//	private int jobSeekerCVid;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "added_date_time")
	private LocalDateTime addedDateTime;
	
	@JsonIgnoreProperties("jobSeekerCVSkills")
	@ManyToOne()
	@JoinColumn(name = "job_seeker_cv_id")
	private JobSeekerCV jobSeekerCV;
	
	
}
