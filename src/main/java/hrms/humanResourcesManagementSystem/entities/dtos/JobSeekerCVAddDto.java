package hrms.humanResourcesManagementSystem.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerCVAddDto {
	
	private Integer jobSeekerId;
	private String coverLetter;
	private Boolean active;
	
}

