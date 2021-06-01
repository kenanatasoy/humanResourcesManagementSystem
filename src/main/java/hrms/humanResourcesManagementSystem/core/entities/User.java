package hrms.humanResourcesManagementSystem.core.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@NotNull
	@NotBlank
	@Column(name = "first_name")
	private String firstName;
	
	@NotNull
	@NotBlank
	@Column(name = "last_name")
	private String lastName;
	
	@NotNull
	@NotBlank
	@Email
	@Column(name = "email_address", unique = true)
	private String emailAddress;
	
//	TODO: Anostasyonlar ile custom validation konusunu öğrenince işverenin web sitesi ile
//	aynı domain'e sahip e-posta girmesi koşulunu yazıcağız
	
	@NotNull
	@NotBlank
	@Column(name = "password")
	private String password;
	
//	TODO: Şifre tekrarı mevzusu back-end'te nasıl hâlledilir
	
	
}
