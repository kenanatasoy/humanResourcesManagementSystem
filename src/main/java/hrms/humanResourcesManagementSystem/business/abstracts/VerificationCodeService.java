package hrms.humanResourcesManagementSystem.business.abstracts;

import java.util.List;

import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.entities.concretes.VerificationCode;

public interface VerificationCodeService {
	
	DataResult<List<VerificationCode>> getAll();
	DataResult<VerificationCode> get(int id);
	DataResult<VerificationCode> getByUserId(int userId);
	Result add(VerificationCode verificationCode);
	
}
