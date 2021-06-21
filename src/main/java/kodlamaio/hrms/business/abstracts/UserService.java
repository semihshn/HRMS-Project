package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.entities.User;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;

public interface UserService {

	Result add(User user);
	Result update(User user);
	Result delete(User user);
	
	DataResult<List<User>> getAll();
	DataResult<User> get(int id);
}
