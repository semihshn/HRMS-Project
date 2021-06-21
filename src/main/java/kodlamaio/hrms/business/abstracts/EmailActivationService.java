package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.EmailActivation;

public interface EmailActivationService {
	
	Result add(EmailActivation emailActivation);
	Result update(EmailActivation emailActivation);
	Result delete(EmailActivation emailActivation);
	
	DataResult<List<EmailActivation>> getAll();
	DataResult<EmailActivation> get(int id);

}
