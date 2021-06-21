package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.JobExperience;

public interface JobExperienceService {

	Result add(JobExperience jobExperience);
	Result update(JobExperience jobExperience);
	Result delete(JobExperience jobExperience);
	
	DataResult<List<JobExperience>> getAll();
	DataResult<JobExperience> get(int id);
	
}
