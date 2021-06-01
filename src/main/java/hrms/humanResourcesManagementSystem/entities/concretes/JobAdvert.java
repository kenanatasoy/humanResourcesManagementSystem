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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.lang.Nullable;

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
	
	@NotNull
	@NotBlank
	@Column(name = "job_definition")
	private String jobDefinition;

	@Nullable
	@Column(name = "min_salary")
	private Integer minSalary;
	
	@Nullable
	@Column(name = "max_salary")
	private Integer maxSalary;
	
	@NotNull
	@NotBlank
	@Column(name = "number_of_open_positions")
	private int numberOfOpenPositions;
	
	@Column(name = "published_date_time")
	private LocalDateTime publishedDateTime = LocalDateTime.now();
	
	@NotNull
	@NotBlank
	@Column(name = "deadline_for_appeal")
	private LocalDateTime deadLineForAppeal;
	
	@Column(name = "is_active")
	private boolean active = true;
	
	@NotNull
	@NotBlank
	@ManyToOne()
	@JoinColumn(name = "city_id")
	private City city;
	
	@NotNull
	@NotBlank
	@ManyToOne()
	@JoinColumn(name = "job_title_id")
	private JobTitle jobTitle;
	
	@ManyToOne()
	@JoinColumn(name = "employer_id")
	private Employer employer;

	public JobAdvert(int cityId, int jobTitleId, int employerId, String jobDefinition, Integer minSalary, Integer maxSalary, int numberOfOpenPositions,
			LocalDateTime deadLineForAppeal) {
		super();
		this.jobDefinition = jobDefinition;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
		this.numberOfOpenPositions = numberOfOpenPositions;
		this.deadLineForAppeal = deadLineForAppeal;
		this.city = new City();
		this.jobTitle = new JobTitle();
		this.employer = new Employer();
		this.city.setId(cityId);
		this.jobTitle.setId(jobTitleId);
		this.employer.setId(employerId);
	}
	
	
}
