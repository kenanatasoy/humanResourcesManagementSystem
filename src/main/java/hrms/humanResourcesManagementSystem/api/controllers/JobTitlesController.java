package hrms.humanResourcesManagementSystem.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.humanResourcesManagementSystem.business.abstracts.JobTitleService;
import hrms.humanResourcesManagementSystem.core.utilities.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.Result;
import hrms.humanResourcesManagementSystem.entities.JobTitle;

@RestController
@RequestMapping("/api/jobtitles/")
public class JobTitlesController {
	
	@Autowired
	private JobTitleService jobTitleService;

	
	@GetMapping("getall")
	public DataResult<List<JobTitle>> getAll(){
		return this.jobTitleService.getAll();
	}
	
	@GetMapping("getbyid")
	public DataResult<JobTitle> get(int id) {
		return this.jobTitleService.get(id);
	}
	
	@PostMapping("delete")
	public Result delete(JobTitle jobTitle) {
		return this.jobTitleService.delete(jobTitle);
	}
	
	@PostMapping("add")
	public Result add(JobTitle jobTitle) {
		return this.jobTitleService.add(jobTitle);
	}
	
	@PostMapping("update")
	public Result update(JobTitle jobTitle){
		return this.jobTitleService.update(jobTitle);
	}
	
}
