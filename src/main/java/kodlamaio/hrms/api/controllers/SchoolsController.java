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

import kodlamaio.hrms.business.abstracts.SchoolService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.School;

@RestController
@RequestMapping("/api/schools")
@CrossOrigin
public class SchoolsController {
	
	private final SchoolService schoolService;

	public SchoolsController(SchoolService schoolService) {
		this.schoolService=schoolService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<School>> getAll(){
		return this.schoolService.getAll();
	}
	
	@GetMapping("/getById")
	public DataResult<School> getById(@RequestParam(value = "schoolId") int schoolId){
		return this.schoolService.getById(schoolId);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody School school) {
		return this.schoolService.add(school);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody School school) {
		return this.schoolService.update(school);
	}
	
	@DeleteMapping("/delete")
	public Result delete(@RequestParam Integer id) {
		return this.schoolService.delete(id);
	}

}
