package hrms.humanResourcesManagementSystem.business.abstracts;

import java.rmi.RemoteException;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import hrms.humanResourcesManagementSystem.core.User;


public interface UserValidationService<T extends User> {

	boolean validate(T t) throws RemoteException;
	
}
