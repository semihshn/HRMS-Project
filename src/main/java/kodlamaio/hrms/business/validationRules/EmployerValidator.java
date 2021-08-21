package kodlamaio.hrms.business.validationRules;

import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.entities.concretes.Employer;

public class EmployerValidator {

	public static Result emailControl(Employer employer) {
		
		String[] emailSplit = employer.getUser().getEmail().split("@");
		
		if (!employer.getWebSite().contains(emailSplit[1])) {
			return new ErrorResult("E-posta adresi, web adresinin bir uzantısı olmalıdır. Örneğin: info@hrms.com , www.hrms.com");
		}
		else {
			return new SuccessResult();
		}
	}
	
}
