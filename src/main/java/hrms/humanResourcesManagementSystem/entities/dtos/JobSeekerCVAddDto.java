package hrms.humanResourcesManagementSystem.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerCVAddDto {
	
	private int jobSeekerId;
	private String githubAddress;
	private String linkedInAddress;
	private String coverLetter;
	private boolean active;
	
}

