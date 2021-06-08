package hrms.humanResourcesManagementSystem.entities.concretes;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "job_seeker_cv_educations")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class JobSeekerCVEducation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
//	@Column(name = "job_seeker_cv_id")
//	private int jobSekeerCVId;
//	
//	@Column(name = "degree_id")
//	private int degreeId;
	
//	@Column(name = "school_id")
//	private int schoolId;

//	@Column(name = "faculty_id")
//	private int facultyId;
	
//	@Column(name = "study_field_id")
//	private int studyFieldId;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Column(name = "starting_date")
	private LocalDate startingDate;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Column(name = "graduation_date")
	private LocalDate graduationDate;
	
	@Column(name = "added_date_time")
	private LocalDateTime addedDateTime;
	
//	@Setter(AccessLevel.NONE)
//	private String calcPhoneNumber;
	
//	@JsonIgnore
	@JsonIgnoreProperties({"jobSeekerCVEducations", "githubAddress", "linkedInAddress",
		"coverLetter", "createdDateTime", "lastUpdatedDateTime", "active", "jobSeekerCVSkills",
		"jobSeekerCVLanguages", "jobSeekerCVExperiences", "jobSeekerCVImage"})
	@ManyToOne()
	@JoinColumn(name = "job_seeker_cv_id")
	private JobSeekerCV jobSeekerCV;
	
	@OneToOne()
	@JoinColumn(name = "degree_id")
	private EducationDegree educationDegree;
	
	@OneToOne()
	@JoinColumn(name = "school_id")
	private EducationSchool educationSchool;
	
	@OneToOne()
	@JoinColumn(name = "faculty_id")
	private EducationFaculty educationFaculty;
	
	@OneToOne()
	@JoinColumn(name = "study_field_id")
	private EducationStudyField educationStudyField;

	
	public JobSeekerCVEducation(int degreeId, int schoolId, int facultyId, 
			int studyFieldId, LocalDate startingDate, LocalDate graduationDate, LocalDateTime addedDateTime,
			int jobSeekerCVId) {
		
		this.educationDegree = new EducationDegree();
		this.educationDegree.setId(degreeId);
		
		this.educationSchool = new EducationSchool();
		this.educationSchool.setId(schoolId);
		
		this.educationFaculty = new EducationFaculty();
		this.educationFaculty.setId(facultyId);
		
		this.educationStudyField = new EducationStudyField();
		this.educationStudyField.setId(studyFieldId);
		
//		this.jobSekeerCVId = jobSeekerCVId;
		
		this.jobSeekerCV = new JobSeekerCV();
		this.jobSeekerCV.setId(jobSeekerCVId);
		
		this.startingDate = startingDate;
		
		this.graduationDate = graduationDate;
		
		this.addedDateTime = addedDateTime;
		
	}
	
	
	
	
}
