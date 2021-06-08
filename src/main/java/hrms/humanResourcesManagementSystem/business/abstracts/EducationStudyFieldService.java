package hrms.humanResourcesManagementSystem.business.abstracts;

import java.util.List;

import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.entities.concretes.EducationStudyField;

public interface EducationStudyFieldService {
	
	DataResult<List<EducationStudyField>> getAll();
	DataResult<List<EducationStudyField>> getByFacultyIdAndActiveTrue(int facultyId);
	DataResult<EducationStudyField> get(int id);
	Result add (EducationStudyField educationStudyField);
	Result update(EducationStudyField educationStudyField);
	Result delete(EducationStudyField educationStudyField);

}
