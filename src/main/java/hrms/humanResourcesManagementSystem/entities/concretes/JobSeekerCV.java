package hrms.humanResourcesManagementSystem.entities.concretes;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "job_seeker_cvs")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdverts"})
// Bu ne alaka burda
public class JobSeekerCV {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "job_seeker_id")
	private int jobSeekerId;
	
	@Column(name = "github_address")
	private String githubAddress;
	
	@Column(name = "linkedin_address")
	private String linkedInAddress;
	
	@Column(name = "cover_letter")
	private String coverLetter;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date_time", updatable = false)
	private Date createdDateTime;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_updated_date_time", insertable = false)
	private Date lastUpdatedDateTime;
	
	@Column(name = "is_active")
	private boolean active;
	
//	@Column(name = "job_seeker_CV_image_id")
//	private int jobSeekerCVImageId;
	
//	@ManyToOne()
//	@JoinColumn(name = "job_seeker_id")
//	private JobSeeker jobSeeker;
	
	
	@OneToMany(mappedBy = "jobSeekerCV", cascade = CascadeType.ALL)
	private List<JobSeekerCVSkill> jobSeekerCVSkills;
	
	@OneToMany(mappedBy = "jobSeekerCV", cascade = CascadeType.ALL)
	private List<JobSeekerCVLanguage> jobSeekerCVLanguages;
	
	@OneToMany(mappedBy = "jobSeekerCV", cascade = CascadeType.ALL)
	private List<JobSeekerCVExperience> jobSeekerCVExperiences;

	@OneToMany(mappedBy = "jobSeekerCV", cascade = CascadeType.ALL)
	private List<JobSeekerCVEducation> jobSeekerCVEducations;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "job_seeker_CV_image_id")
	private JobSeekerCVImage jobSeekerCVImage;

	
	
	
	public JobSeekerCV(int jobSeekerId, String githubAddress, String linkedInAddress,
			String coverLetter, boolean active) {
			
			super();
			this.jobSeekerId = jobSeekerId;
			this.githubAddress = githubAddress;
			this.linkedInAddress = linkedInAddress;
			this.coverLetter = coverLetter;
			this.active = active;
//			this.jobSeekerCVImage = new JobSeekerCVImage();
//			this.jobSeekerCVImage.setId(jobSeekerCVImageId);
//			this.jobSeekerCVImage = new JobSeekerCVImage();
//			this.jobSeekerCVSkills = new ArrayList<JobSeekerCVSkill>();
//			this.jobSeekerCVLanguages = new ArrayList<JobSeekerCVLanguage>();
//			this.jobSeekerCVExperiences = new ArrayList<JobSeekerCVExperience>();
//			this.jobSeekerCVEducations = new ArrayList<JobSeekerCVEducation>();
			
			
	}
	

	
}
