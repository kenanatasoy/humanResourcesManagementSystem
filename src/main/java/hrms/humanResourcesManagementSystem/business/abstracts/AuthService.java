package hrms.humanResourcesManagementSystem.business.abstracts;

import java.rmi.RemoteException;

import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.entities.concretes.Employer;
import hrms.humanResourcesManagementSystem.entities.concretes.JobSeeker;

public interface AuthService {

	Result registerJobSeeker(JobSeeker jobSeeker) throws RemoteException;
	Result registerEmployer(Employer employer) throws RemoteException;
	Result login(String email, String password);
	Result verifyJobSeeker(String userVCode, int jobSeekerId);
	Result verifyEmployer(String userVCode, int employerId);
	Result systemPersonnelConfirmOfEmployer(int systemPersonnelId, int employerId);
	Result systemPersonnelConfirmOfJobAdvert(int systemPersonnelId, int jobAdvertId);
	
}
