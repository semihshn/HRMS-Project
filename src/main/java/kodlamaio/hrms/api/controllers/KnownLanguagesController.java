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

import kodlamaio.hrms.business.abstracts.KnownLanguageService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.KnownLanguage;

@RestController
@RequestMapping("/api/knownlanguages")
@CrossOrigin
public class KnownLanguagesController {

	private final KnownLanguageService knownLanguageService;

	public KnownLanguagesController(KnownLanguageService knownLanguageService) {
		this.knownLanguageService = knownLanguageService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<KnownLanguage>> getAll(){
		return this.knownLanguageService.getAll();
	}
	
	@GetMapping("/getById")
	public DataResult<KnownLanguage> getById(@RequestParam(value = "knownLanguageId") int knownLanguageId){
		return this.knownLanguageService.getById(knownLanguageId);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody KnownLanguage knownLanguage) {
		return this.knownLanguageService.add(knownLanguage);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody KnownLanguage knownLanguage) {
		return this.knownLanguageService.update(knownLanguage);
	}
	
	@DeleteMapping("/delete")
	public Result delete(@RequestParam Integer id) {
		return this.knownLanguageService.delete(id);
	}
	
}
