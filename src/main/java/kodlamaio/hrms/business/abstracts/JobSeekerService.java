package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.business.BaseService;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.JobSeeker;

public interface JobSeekerService extends BaseService<JobSeeker,Integer>{
	
	Result checkIfNationalIdExist(String identityNumber);
	
}
