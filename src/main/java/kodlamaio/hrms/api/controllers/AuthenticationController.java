package kodlamaio.hrms.api.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.AuthenticationService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.entities.dtos.LoginDto;

@RestController
@RequestMapping("/api/authentication")
@CrossOrigin
public class AuthenticationController {
	
	private final AuthenticationService authenticationService;

	public AuthenticationController(AuthenticationService authenticationService) {
		this.authenticationService=authenticationService;
	}
	
	@GetMapping("/login")
	public DataResult<LoginDto> login(@RequestParam(value = "email") String email,@RequestParam(value = "password") String password){
		return this.authenticationService.login(email, password);
	}

}
