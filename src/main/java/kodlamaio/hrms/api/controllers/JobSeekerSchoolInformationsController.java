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

import kodlamaio.hrms.business.abstracts.JobSeekerSchoolInformationService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.JobSeekerSchoolInformation;

@RestController
@RequestMapping("/api/jobseekerschoolinformations")
@CrossOrigin
public class JobSeekerSchoolInformationsController {

	private final JobSeekerSchoolInformationService jobSeekerSchoolInformationService;

	public JobSeekerSchoolInformationsController(JobSeekerSchoolInformationService jobSeekerSchoolInformationService) {
		this.jobSeekerSchoolInformationService = jobSeekerSchoolInformationService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobSeekerSchoolInformation>> getAll(){
		return this.jobSeekerSchoolInformationService.getAll();
	}
	
	@GetMapping("/getById")
	public DataResult<JobSeekerSchoolInformation> getById(@RequestParam(value = "jobSeekerSchoolInformationId") int jobSeekerSchoolInformationId){
		return this.jobSeekerSchoolInformationService.getById(jobSeekerSchoolInformationId);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobSeekerSchoolInformation jobSeekerSchoolInformation) {
		return this.jobSeekerSchoolInformationService.add(jobSeekerSchoolInformation);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody JobSeekerSchoolInformation jobSeekerSchoolInformation) {
		return this.jobSeekerSchoolInformationService.update(jobSeekerSchoolInformation);
	}
	
	@DeleteMapping("/delete")
	public Result delete(@RequestParam Integer id) {
		return this.jobSeekerSchoolInformationService.delete(id);
	}
	
}
