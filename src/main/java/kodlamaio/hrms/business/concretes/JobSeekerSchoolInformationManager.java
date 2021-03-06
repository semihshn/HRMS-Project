package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerSchoolInformationService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerSchoolInformationDao;
import kodlamaio.hrms.entities.concretes.JobSeekerSchoolInformation;

@Service
public class JobSeekerSchoolInformationManager implements JobSeekerSchoolInformationService{

	private final JobSeekerSchoolInformationDao jobSeekerSchoolInformationDao;
	
	public JobSeekerSchoolInformationManager(JobSeekerSchoolInformationDao jobSeekerSchoolInformationDao) {
		this.jobSeekerSchoolInformationDao = jobSeekerSchoolInformationDao;
	}

	@Override
	public Result add(JobSeekerSchoolInformation jobSeekerSchoolInformation) {
		// TODO Auto-generated method stub
		this.jobSeekerSchoolInformationDao.save(jobSeekerSchoolInformation);
		return new SuccessResult("İş arayan okul bilgileri kaydı eklendi");
	}

	@Override
	public Result update(JobSeekerSchoolInformation jobSeekerSchoolInformation) {
		// TODO Auto-generated method stub
		this.jobSeekerSchoolInformationDao.save(jobSeekerSchoolInformation);
		return new SuccessResult("İş arayan okul bilgileri kaydı güncellendi");
	}

	@Override
	public Result delete(Integer id) {
		// TODO Auto-generated method stub
		this.jobSeekerSchoolInformationDao.deleteById(id);
		return new SuccessResult("İş arayan okul bilgileri kaydı silindi");
	}

	@Override
	public DataResult<List<JobSeekerSchoolInformation>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JobSeekerSchoolInformation>>(this.jobSeekerSchoolInformationDao.findAll());
	}

	@Override
	public DataResult<JobSeekerSchoolInformation> getById(Integer id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<JobSeekerSchoolInformation>(this.jobSeekerSchoolInformationDao.findById(id).get());
	}
	
}
