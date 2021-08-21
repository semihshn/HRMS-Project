package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobSeekerContactInformationService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.JobSeekerContactInformation;

@RestController
@RequestMapping("/api/jobseekercontactinformations")
@CrossOrigin
public class JobSeekerContactInformationsController {

	private final JobSeekerContactInformationService jobSeekerContactInformationService;

	public JobSeekerContactInformationsController(JobSeekerContactInformationService jobSeekerContactInformationService) {
		this.jobSeekerContactInformationService = jobSeekerContactInformationService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobSeekerContactInformation>> getAll(){
		return this.jobSeekerContactInformationService.getAll();
	}
	
	@GetMapping("/getById")
	public DataResult<JobSeekerContactInformation> getById(@RequestParam(value = "jobSeekerContactInformationId") int jobSeekerContactInformationId){
		return this.jobSeekerContactInformationService.getById(jobSeekerContactInformationId);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobSeekerContactInformation jobSeekerContactInformation) {
		return this.jobSeekerContactInformationService.add(jobSeekerContactInformation);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody JobSeekerContactInformation jobSeekerContactInformation) {
		return this.jobSeekerContactInformationService.update(jobSeekerContactInformation);
	}
	
	@DeleteMapping("/delete")
	public Result delete(@RequestParam Integer id) {
		return this.jobSeekerContactInformationService.delete(id);
	}
	
}
