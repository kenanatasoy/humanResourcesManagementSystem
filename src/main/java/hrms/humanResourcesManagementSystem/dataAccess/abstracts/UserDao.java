package hrms.humanResourcesManagementSystem.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.humanResourcesManagementSystem.core.User;

public interface UserDao extends JpaRepository<User, Integer>{

}
