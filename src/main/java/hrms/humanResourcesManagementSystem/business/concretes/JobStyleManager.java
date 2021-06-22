package hrms.humanResourcesManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.humanResourcesManagementSystem.business.abstracts.JobStyleService;
import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessDataResult;
import hrms.humanResourcesManagementSystem.dataAccess.abstracts.JobStyleDao;
import hrms.humanResourcesManagementSystem.entities.concretes.JobStyle;

@Service
public class JobStyleManager implements JobStyleService {

	@Autowired
	private JobStyleDao jobStyleDao;
	
	@Override
	public DataResult<List<JobStyle>> getAll() {
		return new SuccessDataResult<List<JobStyle>>(this.jobStyleDao.findAll());
	}

	@Override
	public DataResult<JobStyle> get(int id) {
		return new SuccessDataResult<JobStyle>(this.jobStyleDao.getOne(id));
	}

	@Override
	public Result add(JobStyle jobStyle) {
		// TODO Auto-generated method stub
		return null;
	}

}
