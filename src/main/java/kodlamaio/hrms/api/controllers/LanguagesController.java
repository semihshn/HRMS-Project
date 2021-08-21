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

import kodlamaio.hrms.business.abstracts.LanguageService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Language;

@RestController
@RequestMapping("/api/languages")
@CrossOrigin
public class LanguagesController {
	
	private final LanguageService languageService;

	public LanguagesController(LanguageService languageService) {
		this.languageService=languageService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Language>> getAll(){
		return this.languageService.getAll();
	}
	
	@GetMapping("/getById")
	public DataResult<Language> getById(@RequestParam(value = "languageId") int languageId){
		return this.languageService.getById(languageId);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Language language) {
		return this.languageService.add(language);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody Language language) {
		return this.languageService.update(language);
	}
	
	@DeleteMapping("/delete")
	public Result delete(@RequestParam Integer id) {
		return this.languageService.delete(id);
	}
	
}
