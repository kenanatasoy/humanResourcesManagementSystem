package hrms.humanResourcesManagementSystem.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_seeker_cv_images")
@Entity
public class JobSeekerCVImage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
//	@Column(name = "job_seeker_CV_id")
//	private int jobSeekerCVId;
	
	@Column(name = "image_url")
	private String imageUrl;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "added_date_time", updatable = false)
	private Date createdDateTime;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_updated_date_time", insertable = false)
	private Date lastUpdatedDateTime;
	
//	@OneToOne()
//	@JoinColumn(name = "job_seeker_CV_id", referencedColumnName = "id")
//	private JobSeekerCV jobSeekerCV;
	
	
}
