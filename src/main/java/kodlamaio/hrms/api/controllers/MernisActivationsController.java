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

import kodlamaio.hrms.business.abstracts.MernisActivationService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.MernisActivation;

@RestController
@RequestMapping("/api/mernisactivations")
@CrossOrigin
public class MernisActivationsController {

	private final MernisActivationService mernisActivationService;

	public MernisActivationsController(MernisActivationService mernisActivationService) {
		this.mernisActivationService=mernisActivationService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<MernisActivation>> getAll(){
		return this.mernisActivationService.getAll();
	}
	
	@GetMapping("/getById")
	public DataResult<MernisActivation> getById(@RequestParam(value = "mernisActivationId") int mernisActivationId){
		return this.mernisActivationService.getById(mernisActivationId);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody MernisActivation mernisActivation) {
		return this.mernisActivationService.add(mernisActivation);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody MernisActivation mernisActivation) {
		return this.mernisActivationService.update(mernisActivation);
	}
	
	@DeleteMapping("/delete")
	public Result delete(@RequestParam Integer id) {
		return this.mernisActivationService.delete(id);
	}
	
}
