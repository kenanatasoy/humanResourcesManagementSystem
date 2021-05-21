package hrms.humanResourcesManagementSystem.consoleUI;

import java.rmi.RemoteException;
import java.time.LocalDate;

import hrms.humanResourcesManagementSystem.entities.JobSeeker;


public class Main {

	public static void main(String[] args) {
		
		
		JobSeeker jobSeeker = new JobSeeker();
		jobSeeker.setNationalIdNo("29875715284");
		jobSeeker.setFirstName("KENAN");
		jobSeeker.setLastName("ATASOY");
		jobSeeker.setBirthDate(LocalDate.of(1997, 07, 10));
		
		
	}

}
