package hrms.humanResourcesManagementSystem.business.abstracts;

import java.util.List;

import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.entities.concretes.EducationSchool;

public interface EducationSchoolService {
	DataResult<List<EducationSchool>> getAll();
	DataResult<EducationSchool> get(int id);
	Result add (EducationSchool educationSchool);
	Result update(EducationSchool educationSchool);
	Result delete(EducationSchool educationSchool);
}
