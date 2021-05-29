package hrms.humanResourcesManagementSystem.business.abstracts;

import java.rmi.RemoteException;
import java.util.List;

import hrms.humanResourcesManagementSystem.core.utilities.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.Result;
import hrms.humanResourcesManagementSystem.entities.JobSeeker;

public interface JobSeekerService {
	
	DataResult<List<JobSeeker>> getAll();
	DataResult<JobSeeker> get(int id);
	Result add (JobSeeker jobSeeker) throws RemoteException;
	Result update(JobSeeker jobSeeker);
	Result delete(JobSeeker jobSeeker);

}
