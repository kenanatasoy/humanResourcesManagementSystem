package hrms.humanResourcesManagementSystem.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import hrms.humanResourcesManagementSystem.entities.concretes.JobAdvert;
import hrms.humanResourcesManagementSystem.entities.dtos.JobAdvertDto;

@Repository
public interface JobAdvertDao extends JpaRepository<JobAdvert, Integer> {

	@Query("select new hrms.humanResourcesManagementSystem.entities.dtos.JobAdvertDto"
			+ "(jA.id, e.companyName, jA.numberOfOpenPositions,"
			+ " jA.publishedDateTime, jA.deadLineForAppeal) from Employer e"
			+ " inner join e.jobAdverts jA")
	List<JobAdvertDto> getJobAdvertDtosActiveTrue();

//			+ " inner join jT.jobAdverts jA")
	
//	@Query("select new hrms.humanResourcesManagementSystem.entities.dtos.JobAdvertDto"
//			+ "(jA.id, e.companyName, jT.title, jA.numberOfOpenPositions,"
//			+ " jA.publishedDateTime, jA.deadLineForAppeal) from Employer e, JobTitle jT"
//			+ " inner join e.jobAdverts jA"
//			+ " inner join jT.jobAdverts jA")
//	List<JobAdvertDto> getJobAdvertDtosByPublishedDateTimeAndActiveTrue();
	
//	@Query("select new hrms.humanResourcesManagementSystem.entities.dtos.JobAdvertDto"
//			+ "(jA.id, e.companyName, jT.title, jA.numberOfOpenPositions,"
//			+ " jA.publishedDateTime, jA.deadLineForAppeal) from Employer e, JobTitle jT"
//			+ " inner join e.jobAdverts jA"
//			+ " inner join jT.jobAdverts jA")
//	List<JobAdvertDto> getJobAdvertDtosByEmployerIdAndActiveTrue(int EmployerId);


}
