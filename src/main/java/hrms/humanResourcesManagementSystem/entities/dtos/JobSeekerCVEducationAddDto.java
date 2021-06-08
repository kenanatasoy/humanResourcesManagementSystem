package hrms.humanResourcesManagementSystem.entities.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerCVEducationAddDto {

	private int degreeId;
	private int schoolId;
	private int facultyId;
	private int studyFieldId;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate startingDate;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate graduationDate;
	private LocalDateTime addedDateTime;
	private int jobSeekerCVId;

}
