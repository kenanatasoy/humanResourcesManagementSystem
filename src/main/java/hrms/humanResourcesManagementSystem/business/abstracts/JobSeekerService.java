package hrms.humanResourcesManagementSystem.business.abstracts;

import java.rmi.RemoteException;
import java.util.List;

import hrms.humanResourcesManagementSystem.entities.JobSeeker;

public interface JobSeekerService {
	
	List<JobSeeker> getAll();
	JobSeeker get(int id);
	boolean add (JobSeeker jobSeeker) throws RemoteException;
	void update(JobSeeker jobSeeker);
	void delete(JobSeeker jobSeeker);
	void activateJobSeeker(JobSeeker jobSeeker);

}
