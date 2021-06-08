package hrms.humanResourcesManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.humanResourcesManagementSystem.business.abstracts.EducationStudyFieldService;
import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessDataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessResult;
import hrms.humanResourcesManagementSystem.dataAccess.abstracts.EducationStudyFieldDao;
import hrms.humanResourcesManagementSystem.entities.concretes.EducationStudyField;

@Service
public class EducationStudyFieldManager implements EducationStudyFieldService{
	
	@Autowired
	private EducationStudyFieldDao educationStudyFieldDao;

	
	@Override
	public DataResult<List<EducationStudyField>> getAll() {
		return new SuccessDataResult<List<EducationStudyField>>(this.educationStudyFieldDao.findAll());
	}
	
	@Override
	public DataResult<List<EducationStudyField>> getByFacultyIdAndActiveTrue(int facultyId){
		return new SuccessDataResult<List<EducationStudyField>>(this.educationStudyFieldDao
				.getByFacultyIdAndActiveTrue(facultyId));
	}

	@Override
	public DataResult<EducationStudyField> get(int id) {
		return new SuccessDataResult<EducationStudyField>(this.educationStudyFieldDao.getOne(id));
	}

	@Override
	public Result add(EducationStudyField educationStudyField) {
		this.educationStudyFieldDao.saveAndFlush(educationStudyField);
		return new SuccessResult();
	}

	@Override
	public Result update(EducationStudyField educationStudyField) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(EducationStudyField educationStudyField) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
