package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.JobSeekerContactInformation;

public interface JobSeekerContactInformationService {

	Result add(JobSeekerContactInformation jobSeekerContactInformation);
	Result update(JobSeekerContactInformation jobSeekerContactInformation);
	Result delete(JobSeekerContactInformation jobSeekerContactInformation);
	
	DataResult<List<JobSeekerContactInformation>> getAll();
	DataResult<JobSeekerContactInformation> get(int id);
	
}
