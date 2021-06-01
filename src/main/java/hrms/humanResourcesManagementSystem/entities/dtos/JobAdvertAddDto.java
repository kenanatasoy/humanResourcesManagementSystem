package hrms.humanResourcesManagementSystem.entities.dtos;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertAddDto {
	private int cityId;
	private int jobTitleId;
	private int employerId;
	private String jobDefinition;
	private Integer minSalary;
	private Integer maxSalary;
	private int numberOfOpenPositions;
	private LocalDateTime deadLineForAppeal;
}
