package hrms.humanResourcesManagementSystem.entities.concretes;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class VerificationCode {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "code", unique = true)
	private String code;
	
	@Column(name = "is_verified")
	private Boolean isVerified = false;
	
	@Column(name = "user_id")
	private Integer userId;
	
	@Column(name = "created_date_time")
	private LocalDateTime createdDateTime = LocalDateTime.now();
	
	@Column(name = "confirm_date_time")
	private LocalDateTime confirmDateTime;
	
	@Column(name = "expiration_date_time")
	private LocalDateTime expirationDateTime = LocalDateTime.now().plusHours(24);
	
}
