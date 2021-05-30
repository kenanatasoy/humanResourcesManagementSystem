package hrms.humanResourcesManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.humanResourcesManagementSystem.business.abstracts.VerificationCodeService;
import hrms.humanResourcesManagementSystem.core.utilities.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.Result;
import hrms.humanResourcesManagementSystem.core.utilities.SuccessDataResult;
import hrms.humanResourcesManagementSystem.core.utilities.SuccessResult;
import hrms.humanResourcesManagementSystem.dataAccess.abstracts.VerificationCodeDao;
import hrms.humanResourcesManagementSystem.entities.concretes.VerificationCode;

@Service
public class VerificationCodeManager implements VerificationCodeService{

	@Autowired
	private VerificationCodeDao verificationDao;
	
	
	@Override
	public Result add(VerificationCode verificationCode) {
		this.verificationDao.saveAndFlush(verificationCode);
		return new SuccessResult();
	}

	@Override
	public DataResult<VerificationCode> get(int id) {
		return new SuccessDataResult<VerificationCode>(this.verificationDao.getOne(id));
	}
	
	@Override
	public DataResult<VerificationCode> getByUserId(int userId){
		return new SuccessDataResult<VerificationCode>(this.verificationDao.getByUserId(userId));
	}

	@Override
	public DataResult<List<VerificationCode>> getAll() {
		return new SuccessDataResult<List<VerificationCode>>(this.verificationDao.findAll());
	}
	


}
