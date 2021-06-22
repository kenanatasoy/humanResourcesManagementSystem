package hrms.humanResourcesManagementSystem.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import hrms.humanResourcesManagementSystem.entities.concretes.JobAdvert;
import hrms.humanResourcesManagementSystem.entities.dtos.JobAdvertGetDto;

@Repository
public interface JobAdvertDao extends JpaRepository<JobAdvert, Integer> {
	
	@Query("select new hrms.humanResourcesManagementSystem.entities.dtos.JobAdvertGetDto"
            + "(jA.id, e.companyName, jT.title, c.name, jA.jobDefinition,"
            + " jA.numberOfOpenPositions, jA.publishedDateTime, jA.deadLineForAppeal)"
            + " from Employer e"
            + " inner join e.jobAdverts jA inner join jA.jobTitle jT inner join jA.city c"
            + " inner join SystemPersonnelConfirmOfJobAdvert sPCOJA on sPCOJA.jobAdvertId=jA.id"
            + " where jA.active = true and sPCOJA.didConfirm = true")
	List<JobAdvertGetDto> getConfirmedJobAdvertDtosByActiveTrue();


	@Query("select new hrms.humanResourcesManagementSystem.entities.dtos.JobAdvertGetDto"
            + "(jA.id, e.companyName, jT.title, c.name, jA.jobDefinition, jA.numberOfOpenPositions,"
            + " jA.publishedDateTime, jA.deadLineForAppeal) from Employer e"
            + " inner join e.jobAdverts jA inner join jA.jobTitle jT inner join jA.city"
            + " c inner join SystemPersonnelConfirmOfJobAdvert sPCOJA on sPCOJA.jobAdvertId=jA.id"
            + " where jA.active = true and sPCOJA.didConfirm = true and jA.id=:jobAdvertId")
	JobAdvertGetDto getConfirmedJobAdvertDtoByIdAndActiveTrue(int jobAdvertId);
	
	@Query("select new hrms.humanResourcesManagementSystem.entities.dtos.JobAdvertGetDto"
            + "(jA.id, e.companyName, jT.title, c.name, jA.jobDefinition, jA.numberOfOpenPositions,"
            + " jA.publishedDateTime, jA.deadLineForAppeal) from Employer e"
            + " inner join e.jobAdverts jA inner join jA.jobTitle jT inner join jA.city c"
            + " inner join SystemPersonnelConfirmOfJobAdvert sPCOJA on sPCOJA.jobAdvertId=jA.id"
            + " where jA.active = true and sPCOJA.didConfirm = true"
            + " order by jA.publishedDateTime desc")
	List<JobAdvertGetDto> getConfirmedJobAdvertDtosByPublishedDateTimeAndActiveTrue();

	@Query("select new hrms.humanResourcesManagementSystem.entities.dtos.JobAdvertGetDto"
            + "(jA.id, e.companyName, jT.title, c.name, jA.jobDefinition, jA.numberOfOpenPositions,"
            + " jA.publishedDateTime, jA.deadLineForAppeal) from Employer e"
            + " inner join e.jobAdverts jA inner join jA.jobTitle jT inner join jA.city c"
            + " inner join SystemPersonnelConfirmOfJobAdvert sPCOJA on sPCOJA.jobAdvertId=jA.id"
            + " where jA.active = true and sPCOJA.didConfirm = true and e.id=:employerId")
	List<JobAdvertGetDto> getConfirmedJobAdvertDtosByEmployerIdAndActiveTrue(int employerId);

	
}
