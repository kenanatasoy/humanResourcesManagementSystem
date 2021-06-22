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
	private Integer id;
	
//	@Column(name = "job_type_id")
//	private Integer jobTypeId;
//	
//	@Column(name = "job_style_id")
//	private Integer jobStyleId;
//	
//	@Column(name = "city_id")
//	private Integer cityId;
//
//	@Column(name = "job_title_id")
//	private Integer jobTitleId;
//	
//	@Column(name = "employer_id")
//	private Integer employerId;
	
	@NotBlank
	@Column(name = "job_definition")
	private String jobDefinition;

	@Nullable
	@Column(name = "min_salary")
	private Integer minSalary;
	
	@Nullable
	@Column(name = "max_salary")
	private Integer maxSalary;
	
	@NotBlank
	@Column(name = "number_of_open_positions")
	private Integer numberOfOpenPositions;
	
	@Column(name = "published_date_time")
	private LocalDateTime publishedDateTime;
	
	@NotBlank
	@Column(name = "deadline_for_appeal")
	private LocalDateTime deadLineForAppeal;
	
	@Column(name = "is_active")
	private Boolean active = true;
	
	@NotBlank
	@ManyToOne()
	@JoinColumn(name = "city_id")
	private City city;
	
	@NotBlank
	@ManyToOne()
	@JoinColumn(name = "job_title_id")
	private JobTitle jobTitle;
	
	@NotBlank
	@ManyToOne()
	@JoinColumn(name = "employer_id")
	private Employer employer;
	
	@NotBlank
	@ManyToOne()
	@JoinColumn(name = "job_type_id")
	private JobType jobType;
	
	@NotBlank
	@ManyToOne()
	@JoinColumn(name = "job_style_id")
	private JobStyle jobStyle;
	
//	@OneToOne(mappedBy = "jobAdvert")
//	private SystemPersonnelConfirmOfJobAdvert systemPersonnelConfirmOfJobAdvert;
	
	
	
	
	public JobAdvert(Integer cityId, Integer jobTitleId, Integer employerId, Integer jobTypeId,
			Integer jobStyleId, String jobDefinition, Integer minSalary, Integer maxSalary,
			int numberOfOpenPositions, LocalDateTime deadLineForAppeal) {
		// JobAdvertAddDto Constructor
		
		super();
		
		this.jobDefinition = jobDefinition;
		
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
		
		this.numberOfOpenPositions = numberOfOpenPositions;
		this.deadLineForAppeal = deadLineForAppeal;
		
		this.city = new City();
		this.city.setId(cityId);
		
		this.jobTitle = new JobTitle();
		this.jobTitle.setId(jobTitleId);
		
		this.employer = new Employer();
		this.employer.setId(employerId);
		
		this.jobType = new JobType();
		this.jobType.setId(jobTypeId);
		
		this.jobStyle = new JobStyle();
		this.jobStyle.setId(jobStyleId);
		
	}
	
	
}
