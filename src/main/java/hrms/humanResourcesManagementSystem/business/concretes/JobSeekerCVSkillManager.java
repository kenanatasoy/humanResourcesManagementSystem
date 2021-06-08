package hrms.humanResourcesManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.humanResourcesManagementSystem.business.abstracts.JobSeekerCVSkillService;
import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessDataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessResult;
import hrms.humanResourcesManagementSystem.dataAccess.abstracts.JobSeekerCVSkillDao;
import hrms.humanResourcesManagementSystem.entities.concretes.JobSeekerCVSkill;

@Service
public class JobSeekerCVSkillManager implements JobSeekerCVSkillService {

	@Autowired
	private JobSeekerCVSkillDao jobSeekerCVSkillDao;

	
	@Override
	public DataResult<List<JobSeekerCVSkill>> getAll() {
		return new SuccessDataResult<List<JobSeekerCVSkill>>(this.jobSeekerCVSkillDao.findAll());
	}

	@Override
	public DataResult<JobSeekerCVSkill> get(int id) {
		return new SuccessDataResult<JobSeekerCVSkill>(this.jobSeekerCVSkillDao.getOne(id));
	}

	@Override
	public Result add(JobSeekerCVSkill jobSeekerCVSkill) {
		this.jobSeekerCVSkillDao.saveAndFlush(jobSeekerCVSkill);
		return new SuccessResult();
	}

	@Override
	public Result update(JobSeekerCVSkill jobSeekerCVSkill) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(JobSeekerCVSkill jobSeekerCVSkill) {
		// TODO Auto-generated method stub
		return null;
	} 
 	
	
}
