package hrms.humanResourcesManagementSystem.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerCVLanguageGetDto {
	
	private Integer id;
	private String language;
	private String proficiency;

}
