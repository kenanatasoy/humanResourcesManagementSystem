package hrms.humanResourcesManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.humanResourcesManagementSystem.business.abstracts.EmailService;
import hrms.humanResourcesManagementSystem.business.abstracts.EmployerService;
import hrms.humanResourcesManagementSystem.business.abstracts.JobAdvertService;
import hrms.humanResourcesManagementSystem.business.abstracts.SystemPersonnelConfirmOfJobAdvertService;
import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.ErrorResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessDataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessResult;
import hrms.humanResourcesManagementSystem.dataAccess.abstracts.JobAdvertDao;
import hrms.humanResourcesManagementSystem.entities.concretes.Employer;
import hrms.humanResourcesManagementSystem.entities.concretes.JobAdvert;
import hrms.humanResourcesManagementSystem.entities.concretes.SystemPersonnelConfirmOfJobAdvert;
import hrms.humanResourcesManagementSystem.entities.dtos.JobAdvertAddDto;
import hrms.humanResourcesManagementSystem.entities.dtos.JobAdvertGetDto;

@Service
public class JobAdvertManager implements JobAdvertService {

	@Autowired
	private JobAdvertDao jobAdvertDao;
	
	@Autowired
	private EmployerService employerService;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private SystemPersonnelConfirmOfJobAdvertService systemPersonnelConfirmOfJobAdvertService;


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
	public DataResult<List<JobAdvertGetDto>> getConfirmedJobAdvertDtosByActiveTrue(){
		return new SuccessDataResult<List<JobAdvertGetDto>>(this.jobAdvertDao.getConfirmedJobAdvertDtosByActiveTrue(),
				"Veri listelendi.");
	}
	
	@Override
	public DataResult<List<JobAdvertGetDto>> getConfirmedJobAdvertDtosByPublishedDateTimeAndActiveTrue() {
		return new SuccessDataResult<List<JobAdvertGetDto>>(this.jobAdvertDao.getConfirmedJobAdvertDtosByPublishedDateTimeAndActiveTrue(),
				"Veri listelendi");
	}
	
	@Override
	public DataResult<List<JobAdvertGetDto>> getConfirmedJobAdvertDtosByEmployerIdAndActiveTrue(int employerId) {
		return new SuccessDataResult<List<JobAdvertGetDto>>(this.jobAdvertDao
				.getConfirmedJobAdvertDtosByEmployerIdAndActiveTrue(employerId), "Veri listelendi");
	}
	
	@Override
	public DataResult<JobAdvertGetDto> getConfirmedJobAdvertDtoByIdAndActiveTrue(int jobAdvertId){
		return new SuccessDataResult<JobAdvertGetDto>(this.jobAdvertDao
				.getConfirmedJobAdvertDtoByIdAndActiveTrue(jobAdvertId), "Veri listelendi");
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
	public Result add(JobAdvertAddDto jobAdvertAddDto) {

		JobAdvert jobAdvert = new JobAdvert(jobAdvertAddDto.getCityId(), jobAdvertAddDto.getJobTitleId(),
				jobAdvertAddDto.getEmployerId(),jobAdvertAddDto.getJobTypeId(), jobAdvertAddDto.getJobStyleId(),
				jobAdvertAddDto.getJobDefinition(), jobAdvertAddDto.getMinSalary(),
				jobAdvertAddDto.getMaxSalary(), jobAdvertAddDto.getNumberOfOpenPositions(),
				jobAdvertAddDto.getDeadLineForAppeal());
		
		this.jobAdvertDao.saveAndFlush(jobAdvert);
		
		SystemPersonnelConfirmOfJobAdvert systemPersonnelConfirmOfJobAdvert = new SystemPersonnelConfirmOfJobAdvert();
		systemPersonnelConfirmOfJobAdvert.setDidConfirm(false);
		systemPersonnelConfirmOfJobAdvert.setJobAdvertId(jobAdvert.getId());
		
		this.systemPersonnelConfirmOfJobAdvertService.add(systemPersonnelConfirmOfJobAdvert);
		
		Employer employer = this.employerService.get(jobAdvert.getEmployer().getId()).getData();
		
		this.emailService.sendSimpleMessage(employer.getEmailAddress(), "Job Advert Publishing Req Notice",
				"İş ilanınızın yayınlanması için önce sistem personelinin doğrulaması gerekmektedir."
				+ " İş ilanınız sistem personelinin doğrulamasına gönderilmiştir.");
		return new SuccessResult("İlanın yayınlanması için önce sistem personelinin doğrulaması gerekmektedir.");

//		Note: Buraya test amaçlı dinamik bir email adresi yerine statik bir mail adresi 
//		girilebilir. Nihai olarak dinamik email adresi girilmelidir.
	}
	
	@Override
	public Result add(JobAdvert jobAdvert) {
		this.jobAdvertDao.saveAndFlush(jobAdvert);
		return new SuccessResult();
	}

	@Override
	public Result toggleJobAdActivePassive(Integer jobAdvertId, boolean isActivated) {
		
		JobAdvert jobAdvert = this.jobAdvertDao.getOne(jobAdvertId);
		
//		ternary operator example => jobAdvert.isActive() == isActive ? true : false;
		
		if (isActivated == jobAdvert.getActive()) {
			return new ErrorResult("İş ilanı zaten " + (jobAdvert.getActive() == true ? "aktif" : "pasif") + ".");
		}
		
		jobAdvert.setActive(isActivated);
		this.jobAdvertDao.saveAndFlush(jobAdvert);
		Employer employer = this.employerService.get(jobAdvert.getEmployer().getId()).getData();
		this.emailService.sendSimpleMessage(employer.getEmailAddress(), "Job Advert Passive Notice",
				jobAdvert.getId() + " numaralı " + jobAdvert.getJobTitle().getTitle() + 
				" ilanını " + (isActivated == true ? "aktif" : "pasif") + "leştirdiniz.");
		return new SuccessResult(employer.getFirstName() + 
				", İş ilanını aktif-pasif olma durumunu değiştirdi.");
		
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
