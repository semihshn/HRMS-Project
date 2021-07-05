package kodlamaio.hrms.business.adapters.emailService;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessResult;

@Service
public class EmailManager implements EmailAdapter{
	
	public EmailManager() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Result send(final String to, final String title, final String body) {
		// TODO
		return new SuccessResult("Email has send.");
	}
	
}
