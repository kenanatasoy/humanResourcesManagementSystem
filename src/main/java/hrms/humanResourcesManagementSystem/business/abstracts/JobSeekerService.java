package hrms.humanResourcesManagementSystem.business.abstracts;

import java.rmi.RemoteException;
import java.util.List;

import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.entities.concretes.JobSeeker;

public interface JobSeekerService {
	
	DataResult<List<JobSeeker>> getAll();
	DataResult<JobSeeker> get(int id);
	Result add (JobSeeker jobSeeker) throws RemoteException;
	Result update(JobSeeker jobSeeker);
	Result delete(JobSeeker jobSeeker);

}
