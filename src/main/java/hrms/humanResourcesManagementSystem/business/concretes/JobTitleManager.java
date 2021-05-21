package hrms.humanResourcesManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.humanResourcesManagementSystem.business.abstracts.JobTitleService;
import hrms.humanResourcesManagementSystem.dataAccess.abstracts.JobTitleDao;
import hrms.humanResourcesManagementSystem.entities.JobTitle;


@Service
public class JobTitleManager implements JobTitleService {

	
	@Autowired
	private JobTitleDao jobTitleDao;
	
	
	@Override
	public List<JobTitle> getAll() {
		// TODO Auto-generated method stub
		return this.jobTitleDao.findAll();
	}

	@Override
	public JobTitle get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(JobTitle jobTitle) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(JobTitle jobTitle) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(JobTitle jobTitle) {
		// TODO Auto-generated method stub
		
	}

	
}
