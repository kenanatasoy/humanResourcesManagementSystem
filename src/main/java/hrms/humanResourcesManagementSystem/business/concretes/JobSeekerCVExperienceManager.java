package hrms.humanResourcesManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.humanResourcesManagementSystem.business.abstracts.JobSeekerCVExperienceService;
import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessDataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessResult;
import hrms.humanResourcesManagementSystem.dataAccess.abstracts.JobSeekerCVExperienceDao;
import hrms.humanResourcesManagementSystem.entities.concretes.JobSeekerCVExperience;
import hrms.humanResourcesManagementSystem.entities.dtos.JobSeekerCVExperienceAddDto;

@Service
public class JobSeekerCVExperienceManager implements JobSeekerCVExperienceService {

	@Autowired
	private JobSeekerCVExperienceDao jobSeekerCVExperienceDao;
	
	
	@Override
	public DataResult<List<JobSeekerCVExperience>> getAll() {
		return new SuccessDataResult<List<JobSeekerCVExperience>>(this.jobSeekerCVExperienceDao.findAll());
	}
	
	@Override
	public DataResult<List<JobSeekerCVExperience>> getAllByJobSeekerCVIdOrderByEndingDateDesc(int jobSeekerCVId){
		return new SuccessDataResult<List<JobSeekerCVExperience>>
		(this.jobSeekerCVExperienceDao.findAllByJobSeekerCVIdOrderByEndingDateDesc(jobSeekerCVId));
	}

	@Override
	public DataResult<JobSeekerCVExperience> get(int id) {
		return new SuccessDataResult<JobSeekerCVExperience>(this.jobSeekerCVExperienceDao.getOne(id));
	}

	@Override
	public Result add(JobSeekerCVExperienceAddDto jobSeekerCVExperienceAddDto) {
		
		JobSeekerCVExperience jobSeekerCVExperience = new JobSeekerCVExperience(
				jobSeekerCVExperienceAddDto.getJobSeekerCVId(),
				jobSeekerCVExperienceAddDto.getJobTitleId(),
				jobSeekerCVExperienceAddDto.getCityId(),
				jobSeekerCVExperienceAddDto.getInstitutionName(),
				jobSeekerCVExperienceAddDto.getStartingDate(),
				jobSeekerCVExperienceAddDto.getEndingDate());
		
		this.jobSeekerCVExperienceDao.saveAndFlush(jobSeekerCVExperience);
		return new SuccessResult();
	}

	@Override
	public Result update(JobSeekerCVExperience jobSeekerCVExperience) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(JobSeekerCVExperience jobSeekerCVExperience) {
		// TODO Auto-generated method stub
		return null;
	}

}
