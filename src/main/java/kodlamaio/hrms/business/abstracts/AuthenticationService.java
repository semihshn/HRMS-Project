package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.entities.dtos.LoginDto;

public interface AuthenticationService {
	
	DataResult<LoginDto> login(String email,String password);

}
