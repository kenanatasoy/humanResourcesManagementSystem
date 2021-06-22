package hrms.humanResourcesManagementSystem.entities.dtos;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertAddDto {
	
	// Mapped with Constructor
	private Integer cityId;
	private Integer jobTitleId;
	private Integer employerId;
	private Integer jobTypeId;
	private Integer jobStyleId;
	private String jobDefinition;
	private Integer minSalary;
	private Integer maxSalary;
	private Integer numberOfOpenPositions;
	private LocalDateTime deadLineForAppeal;

}
