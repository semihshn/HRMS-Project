package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.JobSeeker;

public interface JobSeekerService {
	
	Result add(JobSeeker jobSeeker);
	Result update(JobSeeker jobSeeker);
	Result delete(JobSeeker jobSeeker);
	
	DataResult<List<JobSeeker>> getAll();
	DataResult<JobSeeker> get(int id);
}
