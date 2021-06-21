package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertDao;
import kodlamaio.hrms.entities.concretes.JobAdvert;

@Service
public class JobAdvertManager implements JobAdvertService{

	private JobAdvertDao jobAdvertDao;
	
	@Autowired
	public JobAdvertManager(JobAdvertDao jobAdvertDao) {
		this.jobAdvertDao = jobAdvertDao;
	}

	@Override
	public Result add(JobAdvert jobAdvert) {
		// TODO Auto-generated method stub
		this.jobAdvertDao.save(jobAdvert);
		return new SuccessResult("İşveren kaydı eklendi");
	}

	@Override
	public Result update(JobAdvert jobAdvert) {
		// TODO Auto-generated method stub
		return new SuccessResult("İşveren kaydı güncellendi");
	}

	@Override
	public Result delete(JobAdvert jobAdvert) {
		// TODO Auto-generated method stub
		return new SuccessResult("İşveren kaydı silindi");
	}

	@Override
	public DataResult<List<JobAdvert>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findAll());
	}

	@Override
	public DataResult<JobAdvert> get(int id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<JobAdvert>(this.jobAdvertDao.findById(id).get());
	}
	
}
