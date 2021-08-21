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

import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import kodlamaio.hrms.entities.dtos.JobSeekerCvDto;

@RestController
@RequestMapping("/api/jobseekers")
@CrossOrigin
public class JobSeekersController {
	
	private final JobSeekerService jobSeekerService;

	public JobSeekersController(JobSeekerService jobSeekerService) {
		this.jobSeekerService = jobSeekerService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobSeeker>> getAll(){
		return this.jobSeekerService.getAll();
	}
	
	@GetMapping("/getById")
	public DataResult<JobSeeker> getById(@RequestParam(value = "jobSeekerId") int jobSeekerId){
		return this.jobSeekerService.getById(jobSeekerId);
	}
	
	@GetMapping("/getAllCv")
	public DataResult<List<JobSeekerCvDto>> getAllCv(){
		return this.jobSeekerService.getAllCv();
	}
	
	@GetMapping("/getAllCvByJobSeeker_Id")
	public DataResult<List<JobSeekerCvDto>> getAllCvByJobSeeker_Id(@RequestParam(value = "jobseekerId") int jobseekerId){
		return this.jobSeekerService.getAllCvByJobSeeker_Id(jobseekerId);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobSeeker jobSeeker) {
		return this.jobSeekerService.add(jobSeeker);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody JobSeeker jobSeeker) {
		return this.jobSeekerService.update(jobSeeker);
	}
	
	@DeleteMapping("/delete")
	public Result delete(@RequestParam Integer id) {
		return this.jobSeekerService.delete(id);
	}

}
