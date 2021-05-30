package hrms.humanResourcesManagementSystem.consoleUI;

import java.time.LocalDate;

import hrms.humanResourcesManagementSystem.entities.concretes.JobSeeker;


public class Main {

	public static void main(String[] args) {
		
		
		JobSeeker jobSeeker = new JobSeeker();
		jobSeeker.setNationalIdNo("29875715284");
		jobSeeker.setFirstName("Kenan");
		jobSeeker.setLastName("Atasoy");
		jobSeeker.setBirthDate(LocalDate.of(1997, 07, 10));
		
		
	}

}
