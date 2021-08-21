package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.JobAdvert;

@RestController
@RequestMapping("/api/jobadverts")
@CrossOrigin
public class JobAdvertsController {

	private final JobAdvertService jobAdvertService;

	public JobAdvertsController(JobAdvertService jobAdvertService) {
		this.jobAdvertService=jobAdvertService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobAdvert>> getAll(){
		return this.jobAdvertService.getAll();
	}
	
	@GetMapping("/getById")
	public DataResult<JobAdvert> getById(@RequestParam(value = "jobAdvertId") int jobAdvertId){
		return this.jobAdvertService.getById(jobAdvertId);
	}
	
	@GetMapping("/getallsorted")
	public DataResult<List<JobAdvert>> getAllSorted(){
		return this.jobAdvertService.getAllSorted();
	}
	
	@GetMapping("/getByEmployerId")
	public DataResult<List<JobAdvert>> getByEmployerId(@RequestParam int employerId){
		return this.jobAdvertService.getByEmployerId(employerId);
	}
	
	@GetMapping("/getByIsActive")
	public DataResult<List<JobAdvert>> getByIsActive(@RequestParam Boolean isActive){
		return this.jobAdvertService.getByIsActive(isActive);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvert jobAdvert) {
		return this.jobAdvertService.add(jobAdvert);
	}
	
	@PutMapping("/update")
	public Result update(@RequestBody JobAdvert jobAdvert) {
		return this.jobAdvertService.update(jobAdvert);
	}
	
	@DeleteMapping("/delete")
	public Result delete(@RequestParam int jobAdvertId) {
		return this.jobAdvertService.delete(jobAdvertId);
	}
	
	@PutMapping("/employerAdvertMakePassive")
	public Result employerAdvertMakePassive(@RequestParam int employerId, @RequestParam int jobAdvertId) {
		return this.jobAdvertService.employerAdvertMakePassive(employerId, jobAdvertId);
	}
	
}
