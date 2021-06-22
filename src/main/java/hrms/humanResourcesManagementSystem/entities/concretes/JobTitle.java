package hrms.humanResourcesManagementSystem.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "job_titles")
//@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdverts"})
public class JobTitle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@NotBlank
	@Column(name = "title", unique = true)
	private String title;
	
	@PrePersist
	void trimTitle() {
		title = title.trim();
	}
	
	//@JsonIgnoreProperties({"jobType", "jobStyle", "jobTitle"}) => TODO: İşe yaramıyor
	@JsonIgnore
	@OneToMany(mappedBy = "jobTitle")
	private List<JobAdvert> jobAdverts;
	
	
}


