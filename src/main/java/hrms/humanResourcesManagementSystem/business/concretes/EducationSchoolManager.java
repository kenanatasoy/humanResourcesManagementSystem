package hrms.humanResourcesManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.humanResourcesManagementSystem.business.abstracts.EducationSchoolService;
import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessDataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessResult;
import hrms.humanResourcesManagementSystem.dataAccess.abstracts.EducationSchoolDao;
import hrms.humanResourcesManagementSystem.entities.concretes.EducationSchool;

@Service
public class EducationSchoolManager implements EducationSchoolService{

	@Autowired
	private EducationSchoolDao educationSchoolDao;
	
	
	@Override
	public DataResult<List<EducationSchool>> getAll() {
		return new SuccessDataResult<List<EducationSchool>>(this.educationSchoolDao.findAll());
	}

	@Override
	public DataResult<EducationSchool> get(int id) {
		return new SuccessDataResult<EducationSchool>(this.educationSchoolDao.getOne(id));
	}

	@Override
	public Result add(EducationSchool educationSchool) {
		this.educationSchoolDao.saveAndFlush(educationSchool);
		return new SuccessResult();
	}

	@Override
	public Result update(EducationSchool educationSchool) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(EducationSchool educationSchool) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
