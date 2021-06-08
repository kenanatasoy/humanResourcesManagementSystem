package hrms.humanResourcesManagementSystem.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.entities.concretes.JobSeekerCVImage;

public interface JobSeekerCVImageService {
	
	DataResult<List<JobSeekerCVImage>> getAll();
	DataResult<JobSeekerCVImage> get(int id);
//	Result add(JobSeekerCVImage jobSeekerCVImage);
	Result saveImage(MultipartFile file, int jobSeekerCVImageId);
	Result update(JobSeekerCVImage jobSeekerCVImage);
	Result delete(JobSeekerCVImage jobSeekerCVImage);

}
