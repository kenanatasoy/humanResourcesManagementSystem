package hrms.humanResourcesManagementSystem.business.abstracts;

import java.util.List;

import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.entities.concretes.EducationFaculty;

public interface EducationFacultyService {
	DataResult<List<EducationFaculty>> getAll();
	DataResult<List<EducationFaculty>> getAllByUniversityIdAndActiveTrue(int schoolId);
	DataResult<EducationFaculty> get(int id);
	Result add (EducationFaculty educationFaculty);
	Result update(EducationFaculty educationFaculty);
	Result delete(EducationFaculty educationFaculty);
}
