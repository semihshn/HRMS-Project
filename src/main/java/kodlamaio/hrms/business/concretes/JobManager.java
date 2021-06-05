package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobDao;
import kodlamaio.hrms.entities.concretes.Job;

@Service
public class JobManager implements JobService{

	private JobDao jobDao;
	
	@Autowired
	public JobManager(JobDao jobDao) {
		this.jobDao = jobDao;
	}

	@Override
	public Result add(Job job) {
		// TODO Auto-generated method stub
		this.jobDao.save(job);
		return new SuccessResult("İş dalı eklendi");
	}

	@Override
	public Result update(Job job) {
		// TODO Auto-generated method stub
		return new SuccessResult("İş dalı güncellendi");
		
	}

	@Override
	public Result delete(Job job) {
		// TODO Auto-generated method stub
		return new SuccessResult("İş dalı silindi");
		
	}

	@Override
	public DataResult<List<Job>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Job>>(jobDao.findAll(),"Meslek verileri getirildi");
	}

	@Override
	public DataResult<Job> get(int id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<Job>(this.jobDao.findById(id).get());
	}

}
