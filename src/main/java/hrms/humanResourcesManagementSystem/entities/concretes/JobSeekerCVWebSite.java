package hrms.humanResourcesManagementSystem.entities.concretes;

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
@Table(name = "job_seeker_cv_web_sites")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class JobSeekerCVWebSite {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "job_seeker_cv_id")
	private Integer jobSeekerCVId;
	
	@Column(name = "github_address")
	private String githubAddress;
	
	@Column(name = "linkedin_address")
	private String linkedInAddress;
	
	@Column(name = "hackerrank_address")
	private String hackerRankAddress;
	
	@Column(name = "leetcode_address")
	private String leetCodeAddress;
	
	@Column(name = "coderbyte_address")
	private String coderByteAddress;
	
	@Column(name = "codility_address")
	private String codilityAddress;
	
	@Column(name = "algoexpert_address")
	private String algoExpertAddress;
	
	@Column(name = "personal_web_site")
	private String personalWebSite;
	
	
}
