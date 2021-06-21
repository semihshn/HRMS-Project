package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.MernisActivationService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.MernisActivation;

@RestController
@RequestMapping("/api/mernisactivations")
public class MernisActivationsController {

	private MernisActivationService mernisActivationService;

	@Autowired
	public MernisActivationsController(MernisActivationService mernisActivationService) {
		this.mernisActivationService=mernisActivationService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<MernisActivation>> getAll(){
		return this.mernisActivationService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody MernisActivation mernisActivation) {
		return this.mernisActivationService.add(mernisActivation);
	}
	
}
