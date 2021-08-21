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

import kodlamaio.hrms.business.abstracts.EmailActivationService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.EmailActivation;

@RestController
@RequestMapping("/api/emailactivations")
@CrossOrigin
public class EmailActivationsController {
	
	private final EmailActivationService emailActivationService;

	public EmailActivationsController(EmailActivationService emailActivationService) {
		this.emailActivationService=emailActivationService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<EmailActivation>> getAll(){
		return this.emailActivationService.getAll();
	}
	
	@GetMapping("/getById")
	public DataResult<EmailActivation> getById(@RequestParam(value = "emailActivationId") int emailActivationId){
		return this.emailActivationService.getById(emailActivationId);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody EmailActivation emailActivation) {
		return this.emailActivationService.add(emailActivation);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody EmailActivation emailActivation) {
		return this.emailActivationService.update(emailActivation);
	}
	
	@DeleteMapping("/delete")
	public Result delete(@RequestParam Integer id) {
		return this.emailActivationService.delete(id);
	}

}
