package hrms.humanResourcesManagementSystem.business.abstracts;

import java.rmi.RemoteException;
import java.util.List;

import hrms.humanResourcesManagementSystem.core.utilities.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.Result;
import hrms.humanResourcesManagementSystem.entities.concretes.Employer;

public interface EmployerService {
	
	DataResult<List<Employer>> getAll();
	DataResult<Employer> get(int id);
	Result add(Employer employer) throws RemoteException;
	Result update(Employer employer);
	Result delete(Employer employer);
}
