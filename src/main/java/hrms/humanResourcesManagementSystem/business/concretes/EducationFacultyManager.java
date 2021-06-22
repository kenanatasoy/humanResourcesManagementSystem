package hrms.humanResourcesManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.humanResourcesManagementSystem.business.abstracts.EducationFacultyService;
import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessDataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessResult;
import hrms.humanResourcesManagementSystem.dataAccess.abstracts.EducationFacultyDao;
import hrms.humanResourcesManagementSystem.entities.concretes.EducationFaculty;

@Service
public class EducationFacultyManager implements EducationFacultyService {

	@Autowired
	private EducationFacultyDao educationFacultyDao;
	
	
	@Override
	public DataResult<List<EducationFaculty>> getAll() {
		return new SuccessDataResult<List<EducationFaculty>>(this.educationFacultyDao.findAll());
	}
	
	@Override
	public DataResult<List<EducationFaculty>> getAllByUniversityIdAndActiveTrue(int schoolId){
		return new SuccessDataResult<List<EducationFaculty>>(this.educationFacultyDao
				.getByUniversityIdAndActiveTrue(schoolId));
	}

	@Override
	public DataResult<EducationFaculty> get(int id) {
		return new SuccessDataResult<EducationFaculty>(this.educationFacultyDao.getOne(id));
	}

	@Override
	public Result add(EducationFaculty educationFaculty) {
		this.educationFacultyDao.saveAndFlush(educationFaculty);
		return new SuccessResult();
	}

	@Override
	public Result update(EducationFaculty educationFaculty) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(EducationFaculty educationFaculty) {
		// TODO Auto-generated method stub
		return null;
	}

}
