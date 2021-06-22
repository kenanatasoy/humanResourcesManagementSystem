package hrms.humanResourcesManagementSystem.entities.dtos;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerCVEducationAddDto {

	private Integer degreeId;
	private Integer schoolId;
	private Integer facultyId;
	private Integer studyFieldId;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate startingDate;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate graduationDate;
	private Integer jobSeekerCVId;

}
