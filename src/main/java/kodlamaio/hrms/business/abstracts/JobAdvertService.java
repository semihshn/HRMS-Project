package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.JobAdvert;

public interface JobAdvertService {
	
	Result add(JobAdvert jobAdvert);
	Result update(JobAdvert jobAdvert);
	Result delete(JobAdvert jobAdvert);
	
	DataResult<List<JobAdvert>> getAll();
	DataResult<JobAdvert> get(int id);

}
