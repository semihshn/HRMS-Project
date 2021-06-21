package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.JobSeekerSchoolInformation;

public interface JobSeekerSchoolInformationService {

	Result add(JobSeekerSchoolInformation jobSeekerSchoolInformation);
	Result update(JobSeekerSchoolInformation jobSeekerSchoolInformation);
	Result delete(JobSeekerSchoolInformation jobSeekerSchoolInformation);
	
	DataResult<List<JobSeekerSchoolInformation>> getAll();
	DataResult<JobSeekerSchoolInformation> get(int id);
	
}
