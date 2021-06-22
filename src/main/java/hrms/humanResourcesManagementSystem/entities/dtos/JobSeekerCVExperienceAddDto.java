package hrms.humanResourcesManagementSystem.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerCVExperienceAddDto {

	private Integer jobSeekerCVId;
	private Integer jobTitleId;
	private Integer cityId;
	private String institutionName;
	private LocalDate startingDate;
	private LocalDate endingDate;
	
}
