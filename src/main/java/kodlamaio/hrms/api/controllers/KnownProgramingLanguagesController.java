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

import kodlamaio.hrms.business.abstracts.KnownProgramingLanguageService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.KnownProgramingLanguage;

@RestController
@RequestMapping("/api/knownprograminglanguages")
@CrossOrigin
public class KnownProgramingLanguagesController {

	private KnownProgramingLanguageService knownProgramingLanguageService;

	@Autowired
	public KnownProgramingLanguagesController(KnownProgramingLanguageService knownProgramingLanguageService) {
		this.knownProgramingLanguageService = knownProgramingLanguageService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<KnownProgramingLanguage>> getAll(){
		return this.knownProgramingLanguageService.getAll();
	}
	
	@GetMapping("/getById")
	public DataResult<KnownProgramingLanguage> getById(@RequestParam(value = "knownProgramingLanguageId") int knownProgramingLanguageId){
		return this.knownProgramingLanguageService.getById(knownProgramingLanguageId);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody KnownProgramingLanguage knownProgramingLanguage) {
		return this.knownProgramingLanguageService.add(knownProgramingLanguage);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody KnownProgramingLanguage knownProgramingLanguage) {
		return this.knownProgramingLanguageService.update(knownProgramingLanguage);
	}
	
	@DeleteMapping("/delete")
	public Result delete(@RequestBody KnownProgramingLanguage knownProgramingLanguage) {
		return this.knownProgramingLanguageService.delete(knownProgramingLanguage);
	}
	
}
