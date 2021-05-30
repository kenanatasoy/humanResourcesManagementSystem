package hrms.humanResourcesManagementSystem.entities.dtos;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertDto {
	
	private int id;
	private String companyName;
	private String jobTitle;
	private String numberOfOpenPositions;
	private LocalDateTime publishedDateTime;
	private LocalDateTime deadLineForAppeal;
	
}
