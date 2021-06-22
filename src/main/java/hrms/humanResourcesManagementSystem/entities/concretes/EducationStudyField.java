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
@Table(name = "education_study_fields")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EducationStudyField {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "university_id")
	private Integer universityId;
	
	@Column(name = "faculty_id")
	private Integer facultyId;
	
	@Column(name = "is_active")
	private Boolean active;

}
