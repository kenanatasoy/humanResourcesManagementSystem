package hrms.humanResourcesManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.humanResourcesManagementSystem.business.abstracts.EducationDegreeService;
import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessDataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessResult;
import hrms.humanResourcesManagementSystem.dataAccess.abstracts.EducationDegreeDao;
import hrms.humanResourcesManagementSystem.entities.concretes.EducationDegree;

@Service
public class EducationDegreeManager implements EducationDegreeService{

	@Autowired
	private EducationDegreeDao educationDegreeDao;
	
	
	@Override
	public DataResult<List<EducationDegree>> getAll() {
		return new SuccessDataResult<List<EducationDegree>>(this.educationDegreeDao.findAll());
	}

	@Override
	public DataResult<EducationDegree> get(int id) {
		return new SuccessDataResult<EducationDegree>(this.educationDegreeDao.getOne(id));
	}

	@Override
	public Result add(EducationDegree educationDegree) {
		this.educationDegreeDao.saveAndFlush(educationDegree);
		return new SuccessResult();
	}

	@Override
	public Result update(EducationDegree educationDegree) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(EducationDegree educationDegree) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
