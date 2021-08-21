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

import kodlamaio.hrms.business.abstracts.PersonalService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Personal;

@RestController
@RequestMapping("/api/personals")
@CrossOrigin
public class PersonalsController {

	private final PersonalService personalService;

	public PersonalsController(PersonalService personalService) {
		this.personalService=personalService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Personal>> getAll(){
		return this.personalService.getAll();
	}
	
	@GetMapping("/getById")
	public DataResult<Personal> getById(@RequestParam(value = "personalId") int personalId){
		return this.personalService.getById(personalId);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Personal personal) {
		return this.personalService.add(personal);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody Personal personal) {
		return this.personalService.update(personal);
	}
	
	@DeleteMapping("/delete")
	public Result delete(@RequestParam Integer id) {
		return this.personalService.delete(id);
	}
	
}
