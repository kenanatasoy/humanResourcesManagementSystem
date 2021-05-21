package hrms.humanResourcesManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.humanResourcesManagementSystem.business.abstracts.EmployerService;
import hrms.humanResourcesManagementSystem.dataAccess.abstracts.EmployerDao;
import hrms.humanResourcesManagementSystem.entities.Employer;

@Service
public class EmployerManager implements EmployerService {

	
	@Autowired
	private EmployerDao employerDao;

	
	@Override
	public List<Employer> getAll() {
		// TODO Auto-generated method stub
		return this.employerDao.findAll();
	}

	@Override
	public Employer get(int id) {
		// TODO Auto-generated method stub
		return this.employerDao.getOne(id);
	}

	@Override
	public void add(Employer employer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Employer employer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Employer employer) {
		// TODO Auto-generated method stub
		
	}

	

}
