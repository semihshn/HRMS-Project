package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerContactInformationService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerContactInformationDao;
import kodlamaio.hrms.entities.concretes.JobSeekerContactInformation;

@Service
public class JobSeekerContactInformationManager implements JobSeekerContactInformationService{

	private JobSeekerContactInformationDao jobSeekerContactInformationDao;
	
	@Autowired
	public JobSeekerContactInformationManager(JobSeekerContactInformationDao jobSeekerContactInformationDao) {
		this.jobSeekerContactInformationDao = jobSeekerContactInformationDao;
	}

	@Override
	public Result add(JobSeekerContactInformation jobSeekerContactInformation) {
		// TODO Auto-generated method stub
		this.jobSeekerContactInformationDao.save(jobSeekerContactInformation);
		return new SuccessResult("İşveren kaydı eklendi");
	}

	@Override
	public Result update(JobSeekerContactInformation jobSeekerContactInformation) {
		// TODO Auto-generated method stub
		return new SuccessResult("İşveren kaydı güncellendi");
	}

	@Override
	public Result delete(JobSeekerContactInformation jobSeekerContactInformation) {
		// TODO Auto-generated method stub
		return new SuccessResult("İşveren kaydı silindi");
	}

	@Override
	public DataResult<List<JobSeekerContactInformation>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JobSeekerContactInformation>>(this.jobSeekerContactInformationDao.findAll());
	}

	@Override
	public DataResult<JobSeekerContactInformation> getById(Integer id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<JobSeekerContactInformation>(this.jobSeekerContactInformationDao.findById(id).get());
	}
	
}
