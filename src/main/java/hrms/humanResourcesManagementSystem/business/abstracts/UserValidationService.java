package hrms.humanResourcesManagementSystem.business.abstracts;

import java.rmi.RemoteException;

import hrms.humanResourcesManagementSystem.core.entities.User;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;


public interface UserValidationService<T extends User> {

	Result validate(T t) throws RemoteException;
	
}
