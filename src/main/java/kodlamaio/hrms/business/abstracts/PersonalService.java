package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.business.BaseService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.entities.concretes.Personal;

public interface PersonalService extends BaseService<Personal,Integer>{
	
	DataResult<Personal> findByUserId(int id);
	
	DataResult<Personal> findByEmailAndPassword(String email,String password);
	
}
