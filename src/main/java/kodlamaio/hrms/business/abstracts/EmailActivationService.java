package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.business.BaseService;
import kodlamaio.hrms.core.entities.User;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.EmailActivation;
import kodlamaio.hrms.entities.dtos.EmailActivationForVerifyDto;
import kodlamaio.hrms.entities.dtos.EmailActivationWithUserDto;

public interface EmailActivationService extends BaseService<EmailActivation,Integer>{
	Result createAndSendActivationCodeByMail(User user, String... emails);

	Result verify(EmailActivationForVerifyDto emailActivationForVerifyDto);
	
	DataResult<EmailActivationWithUserDto> getByEmail(String email);
	
	Result check(String email);

}
