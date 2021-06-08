package hrms.humanResourcesManagementSystem.business.concretes;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import hrms.humanResourcesManagementSystem.business.abstracts.JobSeekerCVImageService;
import hrms.humanResourcesManagementSystem.business.abstracts.JobSeekerCVService;
import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.ErrorResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessDataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.cloudOperations.CloudService;
import hrms.humanResourcesManagementSystem.dataAccess.abstracts.JobSeekerCVImageDao;
import hrms.humanResourcesManagementSystem.entities.concretes.JobSeekerCV;
import hrms.humanResourcesManagementSystem.entities.concretes.JobSeekerCVImage;

@Service
public class JobSeekerCVImageManager implements JobSeekerCVImageService {

	@Autowired
	private JobSeekerCVImageDao jobSeekerCVImageDao;
	@Autowired
	private CloudService cloudService;
	@Autowired
	private JobSeekerCVService jobSeekerCVService;
	
	@Override
	public DataResult<List<JobSeekerCVImage>> getAll() {
		return new SuccessDataResult<List<JobSeekerCVImage>>(this.jobSeekerCVImageDao.findAll());
	}

	@Override
	public DataResult<JobSeekerCVImage> get(int id) {
		return new SuccessDataResult<JobSeekerCVImage>(this.jobSeekerCVImageDao.getOne(id));
	}

//	@Override
//	public Result add(JobSeekerCVImage jobSeekerCVImage) {
//		this.jobSeekerCVImageDao.saveAndFlush(jobSeekerCVImage);
//		return new SuccessResult();
//	}
	
    @Override
    public Result saveImage(MultipartFile file, int jobSeekerCVId) {
        
    	Map<String, String> uploader = (Map<String, String>) cloudService.save(file).getData();
        String imageUrl = uploader.get("url");
        JobSeekerCV jobSeekerCV = jobSeekerCVService.get(jobSeekerCVId).getData();
        if (jobSeekerCV == null) {
			return new ErrorResult("Fotoğraf eklemek istediğiniz CV mevcut değil");
		}
        
        if(jobSeekerCV.getJobSeekerCVImage() == null) {
        	 JobSeekerCVImage jobSeekerCVImage = new JobSeekerCVImage();
        	 jobSeekerCVImage.setImageUrl(imageUrl);
        	 jobSeekerCV.setJobSeekerCVImage(jobSeekerCVImage);
        } else {
        	jobSeekerCV.getJobSeekerCVImage().setImageUrl(imageUrl);
        }
      
        jobSeekerCV.setLastUpdatedDateTime(new Date());
        
        jobSeekerCVService.add(jobSeekerCV);
        //jobSeekerCVImageDao.saveAndFlush(jobSeekerCVImage);
        return new SuccessResult("Fotoğrafı başarıyla eklediniz");
        
    }
    
	@Override
	public Result update(JobSeekerCVImage jobSeekerCVImage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(JobSeekerCVImage jobSeekerCVImage) {
		// TODO Auto-generated method stub
		return null;
	}

}
