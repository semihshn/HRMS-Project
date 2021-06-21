package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Job;

public interface JobService {
	
	Result add(Job job);
	Result update(Job job);
	Result delete(Job job);
	
	DataResult<List<Job>> getAll();
	DataResult<Job> get(int id);
	
}
