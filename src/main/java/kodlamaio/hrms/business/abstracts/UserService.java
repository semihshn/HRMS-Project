package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.business.BaseService;
import kodlamaio.hrms.core.entities.User;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;

public interface UserService extends BaseService<User,Integer>{
	
	DataResult<User> getByEmailWithEmail(String email);
	
	DataResult<User> getByEmailWithUserId(int userId);

	Result checkIfEmailExist(String email);
	
	DataResult<User> findByEmailAndPassword(String email,String password);
	
	
}
