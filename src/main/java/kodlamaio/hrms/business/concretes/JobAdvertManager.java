package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import kodlamaio.hrms.business.abstracts.JobAdvertService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertDao;
import kodlamaio.hrms.entities.concretes.JobAdvert;

@Service
public class JobAdvertManager implements JobAdvertService{

	private final JobAdvertDao jobAdvertDao;
	
	public JobAdvertManager(JobAdvertDao jobAdvertDao) {
		this.jobAdvertDao = jobAdvertDao;
	}

	@Override
	public Result add(JobAdvert jobAdvert) {
		// TODO Auto-generated method stub
		this.jobAdvertDao.save(jobAdvert);
		return new SuccessResult("İş ilanı kaydı eklendi");
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public Result update(JobAdvert jobAdvert) {
		// TODO Auto-generated method stub
		this.jobAdvertDao.save(jobAdvert);
		return new SuccessResult("İş ilanı kaydı güncellendi");
	}

	@Override
	public Result delete(Integer id) {
		// TODO Auto-generated method stub
		this.jobAdvertDao.deleteById(id);
		return new SuccessResult("İş ilanı kaydı silindi");
	}

	@Override
	public DataResult<List<JobAdvert>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findAll());
	}

	@Override
	public DataResult<JobAdvert> getById(Integer id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<JobAdvert>(this.jobAdvertDao.findById(id).get());
	}

	@Override
	public DataResult<List<JobAdvert>> getAllSorted() {
		// TODO Auto-generated method stub
		
		Sort sort= Sort.by(Sort.Direction.DESC,"createdAt");
		
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findAll(sort),"İş ilanları getirildi");
	}

	@Override
	public DataResult<List<JobAdvert>> getByEmployerId(int employerId) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getByEmployerId(employerId),"Firmaya ait iş ilanları getirildi");
	}

	@Override
	public Result employerAdvertMakePassive(int employerId, int jobAdvertId) {
		// TODO Auto-generated method stub
		
		List<JobAdvert> jobAdvert=this.jobAdvertDao.getByEmployerIdOrId(employerId, jobAdvertId);
		
		if (jobAdvert.isEmpty()) {
			
			return new ErrorResult("İş verenin böyle bir ilanı bulunmamakta");
			
		} else {

			jobAdvert.forEach(x->{
				x.setActive(false);
				this.jobAdvertDao.save(x);
			});
			
			return new SuccessResult("İş ilanı kaydı güncellendi");
			
		}
		
	}

	@Override
	public DataResult<List<JobAdvert>> getByIsActive(Boolean isActive) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getByIsActive(isActive));
	}
	
}
