package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ProgramingLanguageService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.ProgramingLanguage;

@RestController
@RequestMapping("/api/programinglanguages")
@CrossOrigin
public class ProgramingLanguagesController {

	private ProgramingLanguageService programingLanguageService;

	@Autowired
	public ProgramingLanguagesController(ProgramingLanguageService programingLanguageService) {
		this.programingLanguageService=programingLanguageService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<ProgramingLanguage>> getAll(){
		return this.programingLanguageService.getAll();
	}
	
	@GetMapping("/getById")
	public DataResult<ProgramingLanguage> getById(@RequestParam(value = "programingLanguageId") int programingLanguageId){
		return this.programingLanguageService.getById(programingLanguageId);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody ProgramingLanguage programingLanguage) {
		return this.programingLanguageService.add(programingLanguage);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody ProgramingLanguage programingLanguage) {
		return this.programingLanguageService.update(programingLanguage);
	}
	
	@DeleteMapping("/delete")
	public Result delete(@RequestBody ProgramingLanguage programingLanguage) {
		return this.programingLanguageService.delete(programingLanguage);
	}
	
}
