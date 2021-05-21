package hrms.humanResourcesManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.humanResourcesManagementSystem.business.abstracts.SystemPersonnelService;
import hrms.humanResourcesManagementSystem.dataAccess.abstracts.SystemPersonnelDao;
import hrms.humanResourcesManagementSystem.entities.Employer;
import hrms.humanResourcesManagementSystem.entities.SystemPersonnel;

@Service
public class SystemPersonnelManager implements SystemPersonnelService {

	
	@Autowired
	private SystemPersonnelDao systemPersonnel;
	

	@Override
	public List<SystemPersonnel> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SystemPersonnel get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(SystemPersonnel systemPersonnel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(SystemPersonnel systemPersonnel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(SystemPersonnel systemPersonnel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void approve(Employer employer, SystemPersonnel systemPersonnel) {
		// TODO Auto-generated method stub
		
	}

}
