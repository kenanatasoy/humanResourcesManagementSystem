package hrms.humanResourcesManagementSystem.business.abstracts;

import java.util.List;

import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.entities.concretes.Language;

public interface LanguageService {

	DataResult<List<Language>> getAll();
	DataResult<Language> get(Integer id);
//	Result add(Language language);
//	Result update(Language language);
//	Result delete(Language language);
	
}
