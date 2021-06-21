package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EmailActivationService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.EmailActivation;

@RestController
@RequestMapping("/api/emailactivations")
public class EmailActivationsController {
	
	private EmailActivationService emailActivationService;

	@Autowired
	public EmailActivationsController(EmailActivationService emailActivationService) {
		this.emailActivationService=emailActivationService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<EmailActivation>> getAll(){
		return this.emailActivationService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody EmailActivation emailActivation) {
		return this.emailActivationService.add(emailActivation);
	}

}
