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

import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.City;

@RestController
@RequestMapping("/api/cities")
@CrossOrigin
public class CitiesController {
	
	private final CityService cityService;

	public CitiesController(CityService cityService) {
		this.cityService=cityService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<City>> getAll(){
		return this.cityService.getAll();
	}
	
	@GetMapping("/getById")
	public DataResult<City> getById(@RequestParam(value = "cityId") int cityId){
		return this.cityService.getById(cityId);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody City city) {
		return this.cityService.add(city);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody City city) {
		return this.cityService.update(city);
	}
	
	@DeleteMapping("/delete")
	public Result delete(@RequestParam Integer id) {
		return this.cityService.delete(id);
	}

}
