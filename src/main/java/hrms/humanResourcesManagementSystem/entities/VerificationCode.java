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
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "verification_codes")
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class VerificationCode {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "code", unique = true)
	private String code;
	
	@Column(name = "is_verified")
	private boolean isVerified = false;
	
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "created_date_time")
	private LocalDateTime createdDateTime = LocalDateTime.now();
	
	@Column(name = "confirm_date_time")
	private LocalDateTime confirmDateTime;
	
	@Column(name = "expiration_date_time")
	private LocalDateTime expirationDateTime = LocalDateTime.now().plusHours(24);
	
}
