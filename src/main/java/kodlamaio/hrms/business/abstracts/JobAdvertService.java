package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.business.BaseService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.JobAdvert;

public interface JobAdvertService extends BaseService<JobAdvert,Integer>{

	DataResult<List<JobAdvert>> getAllSorted();
	
	DataResult<List<JobAdvert>> getByIsActive(Boolean isActive);
	
	DataResult<List<JobAdvert>> getByEmployerId(int employerId);
	
	Result employerAdvertMakePassive(int employerId,int jobAdvertId);
	
}
