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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "job_adverts")
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvert {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
//	@Column(name = "city_id")
//	private int cityId;
//
//	@Column(name = "job_title_id")
//	private int jobTitleId;
//	
//	@Column(name = "employer_id")
//	private int employerId;
	
	@Column(name = "job_definition")
	private String jobDefinition;

	@Column(name = "min_salary", nullable = true)
	private int minSalary;
	
	@Column(name = "max_salary", nullable = true)
	private int maxSalary;
	
	@Column(name = "number_of_open_positions")
	private int numberOfOpenPositions;
	
	@Column(name = "published_date_time")
	private LocalDateTime publishedDateTime;
	
	@Column(name = "deadline_for_appeal")
	private LocalDateTime deadlineForAppeal;
	
	@Column(name = "is_active")
	private boolean active;
	
	@ManyToOne()
	@JoinColumn(name = "city_id")
	private City city;
	
	@ManyToOne()
	@JoinColumn(name = "job_title_id")
	private JobTitle jobTitle;
	
	@ManyToOne()
	@JoinColumn(name = "employer_id")
	private Employer employer;
	
	
}
