package hrms.humanResourcesManagementSystem.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.humanResourcesManagementSystem.business.abstracts.EmailService;
import hrms.humanResourcesManagementSystem.business.abstracts.EmployerService;
import hrms.humanResourcesManagementSystem.business.abstracts.JobAdvertService;
import hrms.humanResourcesManagementSystem.core.utilities.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.Result;
import hrms.humanResourcesManagementSystem.core.utilities.SuccessDataResult;
import hrms.humanResourcesManagementSystem.core.utilities.SuccessResult;
import hrms.humanResourcesManagementSystem.dataAccess.abstracts.JobAdvertDao;
import hrms.humanResourcesManagementSystem.entities.concretes.Employer;
import hrms.humanResourcesManagementSystem.entities.concretes.JobAdvert;
import hrms.humanResourcesManagementSystem.entities.dtos.JobAdvertDto;

@Service
public class JobAdvertManager implements JobAdvertService {

	@Autowired
	private JobAdvertDao jobAdvertDao;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private EmployerService employerService;
	
	@Autowired
	private EmailService emailService;
	
	@Override
	public DataResult<List<JobAdvertDto>> getAllJobAds() {
		
		List<JobAdvertDto> jobAdvertDtos = new ArrayList<JobAdvertDto>();
		
		this.jobAdvertDao.findByActiveTrue().stream().forEach(adv->{
			JobAdvertDto jDto = modelMapper.map(adv, JobAdvertDto.class);
			Employer employer = this.employerService.get(adv.getEmployerId()).getData();
			jDto.setCompanyName(employer.getCompanyName());
			jobAdvertDtos.add(jDto);
		});

		return new SuccessDataResult<List<JobAdvertDto>>(jobAdvertDtos, "Tüm veriler listelendi.");
	}
	
	@Override
	public DataResult<List<JobAdvert>> getAll(){
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findAll());
	}

	@Override
	public DataResult<JobAdvert> get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result add(JobAdvert jobAdvert) {

		this.jobAdvertDao.saveAndFlush(jobAdvert);
		Employer employer = this.employerService.get(jobAdvert.getEmployerId()).getData();
		this.emailService.sendSimpleMessage(employer.getEmailAddress(), "Job Advert Addition Notice",
				"İş ilanını eklediniz.");
		return new SuccessResult(employer.getFirstName() + " başarıyla iş ilanını ekledi.");
		
	}

	@Override
	public Result toggleJobAdActivePassive(int employerId, int jobAdvertId) {
		
		JobAdvert jobAdvert = this.jobAdvertDao.getOne(jobAdvertId);
		jobAdvert.setActive(!jobAdvert.isActive());
		this.jobAdvertDao.saveAndFlush(jobAdvert);
		Employer employer = this.employerService.get(jobAdvert.getEmployerId()).getData();
		this.emailService.sendSimpleMessage(employer.getEmailAddress(), "Job Advert Passive Notice",
				"İş ilanının aktif-pasif olma durumunu değiştirdiniz.");
		return new SuccessResult(employer.getFirstName() + " iş ilanının aktif-pasif olma durumunu değiştirdi.");
		
	}
	
	@Override
	public Result update(JobAdvert jobAdvert) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(JobAdvert jobAdvert) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
