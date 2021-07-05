package kodlamaio.hrms.business.adapters.emailService;
import kodlamaio.hrms.core.utilities.result.Result;

public interface EmailAdapter {
	
	Result send(String to, String title, String body);
	
}
