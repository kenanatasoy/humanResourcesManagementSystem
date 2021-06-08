package hrms.humanResourcesManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.humanResourcesManagementSystem.business.abstracts.JobSeekerCVService;
import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessDataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessResult;
import hrms.humanResourcesManagementSystem.dataAccess.abstracts.JobSeekerCVDao;
import hrms.humanResourcesManagementSystem.entities.concretes.JobSeekerCV;
import hrms.humanResourcesManagementSystem.entities.dtos.JobSeekerCVAddDto;

@Service
public class JobSeekerCVManager implements JobSeekerCVService {

	@Autowired
	private JobSeekerCVDao jobSeekerCVDao;
	
	@Override
	public DataResult<List<JobSeekerCV>> getAll() {
		return new SuccessDataResult<List<JobSeekerCV>>(this.jobSeekerCVDao.findAll());
	}

	@Override
	public DataResult<JobSeekerCV> get(int id) {
		return new SuccessDataResult<JobSeekerCV>(this.jobSeekerCVDao.findById(id).orElse(null));
	}

	@Override
	public Result add(JobSeekerCVAddDto jobSeekerCVAddDto) {
		JobSeekerCV jobSeekerCV = new JobSeekerCV(jobSeekerCVAddDto.getJobSeekerId(),
				jobSeekerCVAddDto.getGithubAddress(), jobSeekerCVAddDto.getLinkedInAddress(),
				jobSeekerCVAddDto.getCoverLetter(), jobSeekerCVAddDto.isActive());
		
		this.jobSeekerCVDao.save(jobSeekerCV);
		return new SuccessResult();
	}
	
	@Override
	public Result add(JobSeekerCV jobSeekerCV) {
		this.jobSeekerCVDao.save(jobSeekerCV);
		return new SuccessResult();
	}

	@Override
	public Result update(JobSeekerCV jobSeekerCV) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(JobSeekerCV jobSeekerCV) {
		// TODO Auto-generated method stub
		return null;
	}

}
