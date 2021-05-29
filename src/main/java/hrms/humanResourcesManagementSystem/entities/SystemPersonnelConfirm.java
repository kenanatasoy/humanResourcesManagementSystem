package hrms.humanResourcesManagementSystem.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "system_personnel_confirms")
@Inheritance(strategy = InheritanceType.JOINED)
public class SystemPersonnelConfirm {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "system_personnel_id")
	private int systemPersonnelId;
	
	@Column(name = "did_confirm")
	private boolean didConfirm;
	
	@Column(name = "confirm_date_time")
	private LocalDateTime confirmDateTime;
	
	
}
