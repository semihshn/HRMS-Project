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

import kodlamaio.hrms.business.abstracts.SchoolPartService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.SchoolPart;

@RestController
@RequestMapping("/api/schoolparts")
@CrossOrigin
public class SchoolPartsController {

	private final SchoolPartService schoolPartService;

	public SchoolPartsController(SchoolPartService schoolPartService) {
		this.schoolPartService=schoolPartService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<SchoolPart>> getAll(){
		return this.schoolPartService.getAll();
	}
	
	@GetMapping("/getById")
	public DataResult<SchoolPart> getById(@RequestParam(value = "schoolPartId") int schoolPartId){
		return this.schoolPartService.getById(schoolPartId);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody SchoolPart schoolPart) {
		return this.schoolPartService.add(schoolPart);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody SchoolPart schoolPart) {
		return this.schoolPartService.update(schoolPart);
	}
	
	@DeleteMapping("/delete")
	public Result delete(@RequestParam Integer id) {
		return this.schoolPartService.delete(id);
	}
	
}
