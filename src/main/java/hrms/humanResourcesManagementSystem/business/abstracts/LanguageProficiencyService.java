package hrms.humanResourcesManagementSystem.business.abstracts;

import java.util.List;

import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.entities.concretes.LanguageProficiency;

public interface LanguageProficiencyService {
	DataResult<List<LanguageProficiency>> getAll();
	DataResult<LanguageProficiency> get(Integer id);
//	Result add(LanguageProficiency languageProficiency);
//	Result update(LanguageProficiency languageProficiency);
//	Result delete(LanguageProficiency languageProficiency);

}
