package hrms.humanResourcesManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.humanResourcesManagementSystem.business.abstracts.LanguageService;
import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessDataResult;
import hrms.humanResourcesManagementSystem.dataAccess.abstracts.LanguageDao;
import hrms.humanResourcesManagementSystem.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService{

	@Autowired
	private LanguageDao languageDao;
	
	@Override
	public DataResult<List<Language>> getAll() {
		return new SuccessDataResult<List<Language>>(this.languageDao.findAll());
	}

	@Override
	public DataResult<Language> get(Integer id) {
		return new SuccessDataResult<Language>(this.languageDao.getOne(id));
	}

}
