package hrms.humanResourcesManagementSystem.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hrms.humanResourcesManagementSystem.entities.concretes.JobAdvert;

@Repository
public interface JobAdvertDao extends JpaRepository<JobAdvert, Integer> {

	List<JobAdvert> findByActiveTrue();

}
