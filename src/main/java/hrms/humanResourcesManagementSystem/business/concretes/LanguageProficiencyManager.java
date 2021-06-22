package hrms.humanResourcesManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.humanResourcesManagementSystem.business.abstracts.LanguageProficiencyService;
import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessDataResult;
import hrms.humanResourcesManagementSystem.dataAccess.abstracts.LanguageProficiencyDao;
import hrms.humanResourcesManagementSystem.entities.concretes.LanguageProficiency;

@Service
public class LanguageProficiencyManager implements LanguageProficiencyService {

	@Autowired
	private LanguageProficiencyDao languageProficiencyDao;
	
	@Override
	public DataResult<List<LanguageProficiency>> getAll() {
		return new SuccessDataResult<List<LanguageProficiency>>(this.languageProficiencyDao.findAll());
	}

	@Override
	public DataResult<LanguageProficiency> get(Integer id) {
		return new SuccessDataResult<LanguageProficiency>(this.languageProficiencyDao.getOne(id));
	}

}
