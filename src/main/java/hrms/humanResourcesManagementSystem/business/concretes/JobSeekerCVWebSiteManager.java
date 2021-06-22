package hrms.humanResourcesManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.humanResourcesManagementSystem.business.abstracts.JobSeekerCVWebSiteService;
import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessDataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessResult;
import hrms.humanResourcesManagementSystem.dataAccess.abstracts.JobSeekerCVWebSiteDao;
import hrms.humanResourcesManagementSystem.entities.concretes.JobSeekerCVWebSite;

@Service
public class JobSeekerCVWebSiteManager implements JobSeekerCVWebSiteService{

	@Autowired
	private JobSeekerCVWebSiteDao jobSeekerCVWebSiteDao;
	
	
	@Override
	public DataResult<List<JobSeekerCVWebSite>> getAll() {
		return new SuccessDataResult<List<JobSeekerCVWebSite>>(this.jobSeekerCVWebSiteDao.findAll());
	}

	@Override
	public DataResult<JobSeekerCVWebSite> get(Integer id) {
		return new SuccessDataResult<JobSeekerCVWebSite>(this.jobSeekerCVWebSiteDao.getOne(id));
	}

	@Override
	public Result add(JobSeekerCVWebSite jobSeekerCVWebSite) {
		this.jobSeekerCVWebSiteDao.saveAndFlush(jobSeekerCVWebSite);
		return new SuccessResult();
	}

	@Override
	public Result update(JobSeekerCVWebSite jobSeekerCVWebSite) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result deleteById(Integer jobSeekerCVWebSiteId) {
		this.jobSeekerCVWebSiteDao.deleteById(jobSeekerCVWebSiteId);
		return new SuccessResult();
	}

}
