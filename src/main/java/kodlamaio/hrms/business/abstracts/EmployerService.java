package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerService {
	Result add(Employer employer);
	Result update(Employer employer);
	Result delete(Employer employer);
	
	DataResult<List<Employer>> getAll();
	DataResult<Employer> get(int id);
}
