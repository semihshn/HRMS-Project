package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.business.BaseService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import kodlamaio.hrms.entities.dtos.JobSeekerCvDto;

public interface JobSeekerService extends BaseService<JobSeeker,Integer>{
	
	Result checkIfNationalIdExist(String identityNumber);
	
	DataResult<List<JobSeekerCvDto>> getAllCv();
	
	DataResult<List<JobSeekerCvDto>> getAllCvByJobSeeker_Id(int jobSeekerId);
	
	DataResult<JobSeeker> findByUserId(int id);
	
	DataResult<JobSeeker> getByUserId(int userId);
	
	DataResult<JobSeeker> findByEmailAndPassword(String email,String password);
	
}
