package hrms.humanResourcesManagementSystem.entities.dtos;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertGetDto {

	// Mapped with Jpql Query in JobAdvertDao
	private Integer id;
	private String companyName;
	private String title;
	private String city;
	private String jobDefinition;
	private Integer numberOfOpenPositions;
	private LocalDateTime publishedDateTime;
	private LocalDateTime deadLineForAppeal;

}
