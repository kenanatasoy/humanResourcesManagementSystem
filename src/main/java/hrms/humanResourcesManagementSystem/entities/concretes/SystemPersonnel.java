package hrms.humanResourcesManagementSystem.entities.concretes;


import javax.persistence.Entity;
import javax.persistence.Table;

import hrms.humanResourcesManagementSystem.core.entities.User;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "system_personnels")
public class SystemPersonnel extends User{

	
}
