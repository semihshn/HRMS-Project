package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobExperienceService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobExperienceDao;
import kodlamaio.hrms.entities.concretes.JobExperience;

@Service
public class JobExperienceManager implements JobExperienceService{

	private JobExperienceDao jobExperienceDao;
	
	@Autowired
	public JobExperienceManager(JobExperienceDao jobExperienceDao) {
		this.jobExperienceDao = jobExperienceDao;
	}

	@Override
	public Result add(JobExperience jobExperience) {
		// TODO Auto-generated method stub
		this.jobExperienceDao.save(jobExperience);
		return new SuccessResult("İşveren kaydı eklendi");
	}

	@Override
	public Result update(JobExperience jobExperience) {
		// TODO Auto-generated method stub
		return new SuccessResult("İşveren kaydı güncellendi");
	}

	@Override
	public Result delete(JobExperience jobExperience) {
		// TODO Auto-generated method stub
		return new SuccessResult("İşveren kaydı silindi");
	}

	@Override
	public DataResult<List<JobExperience>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.findAll());
	}

	@Override
	public DataResult<JobExperience> get(int id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<JobExperience>(this.jobExperienceDao.findById(id).get());
	}
	
}
