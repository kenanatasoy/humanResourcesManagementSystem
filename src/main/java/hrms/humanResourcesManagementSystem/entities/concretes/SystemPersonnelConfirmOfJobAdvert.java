package hrms.humanResourcesManagementSystem.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "system_personnel_confirms_of_job_adverts")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SystemPersonnelConfirmOfJobAdvert extends SystemPersonnelConfirm {
	
	@Column(name = "job_advert_id")
	private Integer jobAdvertId;

//	@OneToOne()
//	@JoinColumn(name = "job_advert_id")
//	private JobAdvert jobAdvert;
	
}
