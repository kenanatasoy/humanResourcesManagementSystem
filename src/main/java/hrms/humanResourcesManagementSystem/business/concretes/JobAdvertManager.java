package hrms.humanResourcesManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.humanResourcesManagementSystem.business.abstracts.EmailService;
import hrms.humanResourcesManagementSystem.business.abstracts.EmployerService;
import hrms.humanResourcesManagementSystem.business.abstracts.JobAdvertService;
import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessDataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessResult;
import hrms.humanResourcesManagementSystem.dataAccess.abstracts.JobAdvertDao;
import hrms.humanResourcesManagementSystem.entities.concretes.Employer;
import hrms.humanResourcesManagementSystem.entities.concretes.JobAdvert;
import hrms.humanResourcesManagementSystem.entities.dtos.JobAdvertDto;

@Service
public class JobAdvertManager implements JobAdvertService {

	@Autowired
	private JobAdvertDao jobAdvertDao;
	
	@Autowired
	private EmployerService employerService;
	
	@Autowired
	private EmailService emailService;


//	@Override
//	public DataResult<List<JobAdvertDto>> getAllJobAds() {
//		
//		List<JobAdvertDto> jobAdvertDtos = new ArrayList<JobAdvertDto>();
//		
//		this.jobAdvertDao.findByActiveTrue().stream().forEach(adv->{
//			JobAdvertDto jDto = modelMapper.map(adv, JobAdvertDto.class);
//			Employer employer = this.employerService.get(adv.getEmployer().getId()).getData();
//			jDto.setCompanyName(employer.getCompanyName());
//			jobAdvertDtos.add(jDto);
//		});
//
//		return new SuccessDataResult<List<JobAdvertDto>>(jobAdvertDtos, "Tüm veriler listelendi.");
//	}

	@Override
	public DataResult<List<JobAdvertDto>> getJobAdvertDtosByActiveTrue(){
		return new SuccessDataResult<List<JobAdvertDto>>(this.jobAdvertDao.getJobAdvertDtosByActiveTrue(),
				"Veri listelendi.");
	}
	
	@Override
	public DataResult<List<JobAdvertDto>> getJobAdvertDtosByPublishedDateTimeAndActiveTrue() {
		return new SuccessDataResult<List<JobAdvertDto>>(this.jobAdvertDao.getJobAdvertDtosByPublishedDateTimeAndActiveTrue(),
				"Veri listelendi");
	}
	
	@Override
	public DataResult<List<JobAdvertDto>> getJobAdvertDtosByEmployerIdAndActiveTrue(int employerId) {
		return new SuccessDataResult<List<JobAdvertDto>>(this.jobAdvertDao
				.getJobAdvertDtosByEmployerIdAndActiveTrue(employerId), "Veri listelendi");
	}
	
	@Override
	public DataResult<List<JobAdvert>> getAll(){
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findAll());
	}
	
	@Override
	public DataResult<JobAdvert> get(int id) {
		return new SuccessDataResult<JobAdvert>(this.jobAdvertDao.getOne(id));
	}

	@Override
	public Result add(JobAdvert jobAdvert) {

		this.jobAdvertDao.saveAndFlush(jobAdvert);
		Employer employer = this.employerService.get(jobAdvert.getEmployer().getId()).getData();
		this.emailService.sendSimpleMessage("kenanatasoy@outlook.com", "Job Advert Addition Notice",
				"İş ilanını eklediniz.");
		return new SuccessResult(employer.getFirstName() + " başarıyla iş ilanını ekledi.");

//		TODO: Buraya generic, dinamik bir email adresi girilecek,
//		statik email adresi değiştirilecek
	}

	@Override
	public Result toggleJobAdActivePassive(int employerId, int jobAdvertId) {
		
		JobAdvert jobAdvert = this.jobAdvertDao.getOne(jobAdvertId);
		jobAdvert.setActive(!jobAdvert.isActive());
		this.jobAdvertDao.saveAndFlush(jobAdvert);
		Employer employer = this.employerService.get(jobAdvert.getEmployer().getId()).getData();
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
