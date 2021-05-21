package hrms.humanResourcesManagementSystem.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.humanResourcesManagementSystem.business.abstracts.JobTitleService;
import hrms.humanResourcesManagementSystem.entities.JobTitle;

@RestController
@RequestMapping("/api/jobtitles/")
public class JobTitlesController {
	
	@Autowired
	private JobTitleService jobTitleService;

	
	@GetMapping("getall")
	public List<JobTitle> getAll(){
		return this.jobTitleService.getAll();
	}
	
	@GetMapping("getbyid")
	public JobTitle get(int id) {
		return this.jobTitleService.get(id);
	}
	
	@GetMapping("delete")
	public void delete(JobTitle jobTitle) {
		this.jobTitleService.delete(jobTitle);
	}
	
	@GetMapping("add")
	public void add(JobTitle jobTitle) {
		this.jobTitleService.add(jobTitle);
	}
	
	@GetMapping("update")
	public void update(JobTitle jobTitle){
		this.jobTitleService.update(jobTitle);
	}
	
}
