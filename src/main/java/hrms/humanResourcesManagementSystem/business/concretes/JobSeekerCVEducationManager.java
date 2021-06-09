package hrms.humanResourcesManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.humanResourcesManagementSystem.business.abstracts.JobSeekerCVEducationService;
import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessDataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessResult;
import hrms.humanResourcesManagementSystem.dataAccess.abstracts.JobSeekerCVEducationDao;
import hrms.humanResourcesManagementSystem.entities.concretes.JobSeekerCVEducation;
import hrms.humanResourcesManagementSystem.entities.dtos.JobSeekerCVEducationAddDto;

@Service
public class JobSeekerCVEducationManager implements JobSeekerCVEducationService {

	@Autowired
	private JobSeekerCVEducationDao jobSeekerCVEducationDao;
	
	
	@Override
	public DataResult<List<JobSeekerCVEducation>> getAll() {
		return new SuccessDataResult<List<JobSeekerCVEducation>>(this.jobSeekerCVEducationDao.findAll());
	}
	
	@Override
	public DataResult<List<JobSeekerCVEducation>> 
		getAllByJobSeekerCVIdOrderByGraduationDateDesc(int jobSeekerCVId) {
		return new SuccessDataResult<List<JobSeekerCVEducation>>(this.jobSeekerCVEducationDao
				.findAllByJobSeekerCV_IdOrderByGraduationDateDesc(jobSeekerCVId));
	}

	@Override
	public DataResult<JobSeekerCVEducation> get(int id) {
		return new SuccessDataResult<JobSeekerCVEducation>(this.jobSeekerCVEducationDao.getOne(id));
	}

	@Override
	public Result add(JobSeekerCVEducationAddDto jobSeekerCVEducationAddDto) {
		
		JobSeekerCVEducation jobSeekerCVEducation = new JobSeekerCVEducation(jobSeekerCVEducationAddDto.getDegreeId(),
				jobSeekerCVEducationAddDto.getSchoolId(), jobSeekerCVEducationAddDto.getFacultyId(),
				jobSeekerCVEducationAddDto.getStudyFieldId(), jobSeekerCVEducationAddDto.getStartingDate(),
				jobSeekerCVEducationAddDto.getGraduationDate(), jobSeekerCVEducationAddDto.getJobSeekerCVId());
		
		this.jobSeekerCVEducationDao.save(jobSeekerCVEducation);
		return new SuccessResult();
	}

	@Override
	public Result update(JobSeekerCVEducation jobSeekerCVEducation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(JobSeekerCVEducation jobSeekerCVEducation) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
}
