package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.business.BaseService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerService extends BaseService<Employer,Integer>{
	
	DataResult<Employer> findByUserId(int id);
	
	DataResult<Employer> findByEmailAndPassword(String email,String password);
	
}
