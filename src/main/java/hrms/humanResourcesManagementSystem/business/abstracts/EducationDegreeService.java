package hrms.humanResourcesManagementSystem.business.abstracts;

import java.util.List;

import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.entities.concretes.EducationDegree;

public interface EducationDegreeService {
	DataResult<List<EducationDegree>> getAll();
	DataResult<EducationDegree> get(int id);
	Result add (EducationDegree educationDegree);
	Result update(EducationDegree educationDegree);
	Result delete(EducationDegree educationDegree);
}
