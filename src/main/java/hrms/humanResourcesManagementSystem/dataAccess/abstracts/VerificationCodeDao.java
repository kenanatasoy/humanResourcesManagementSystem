package hrms.humanResourcesManagementSystem.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.humanResourcesManagementSystem.entities.VerificationCode;

public interface VerificationCodeDao extends JpaRepository<VerificationCode, Integer>{

	VerificationCode getByUserId(int userId);
	
}
