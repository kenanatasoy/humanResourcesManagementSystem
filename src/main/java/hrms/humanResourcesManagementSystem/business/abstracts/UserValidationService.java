package hrms.humanResourcesManagementSystem.business.abstracts;

import java.rmi.RemoteException;

import hrms.humanResourcesManagementSystem.core.User;
import hrms.humanResourcesManagementSystem.core.utilities.Result;


public interface UserValidationService<T extends User> {

	Result validate(T t) throws RemoteException;
	
}
