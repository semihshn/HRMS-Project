package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import kodlamaio.hrms.business.abstracts.EmailActivationService;
import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.business.abstracts.MernisActivationService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.business.adapters.mernisService.PersonForValidateFromMernisService;
import kodlamaio.hrms.core.utilities.business.BusinessRules;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import kodlamaio.hrms.entities.dtos.JobSeekerCvDto;
import kodlamaio.hrms.entities.dtos.converter.Converter;
@Service
public class JobSeekerManager implements JobSeekerService{

	private JobSeekerDao jobSeekerDao;
	private UserService userService;
	private EmailActivationService emailActivationService;
	private MernisActivationService mernisActivationService;
	private Converter converter;
	
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao,UserService userService
							,MernisActivationService mernisActivationService
							,EmailActivationService emailActivationService,
							 Converter converter
							) 
	{
		
		this.jobSeekerDao = jobSeekerDao;
		this.userService=userService;
		this.mernisActivationService=mernisActivationService;
		this.emailActivationService=emailActivationService;
		this.converter=converter;
	}

	@Override
	public Result add(JobSeeker jobSeeker) {
		// TODO Auto-generated method stub
		
		Result result=BusinessRules.run(userService.checkIfEmailExist(jobSeeker.getUser().getEmail())
										,this.checkIfNationalIdExist(jobSeeker.getNationalityId())
										,mernisActivationService.check(new PersonForValidateFromMernisService())
										,this.emailVerification(jobSeeker.getUser().getEmail())
												);
		
		if (result.isSuccess()) {
			return result;
		}
		
		this.jobSeekerDao.save(jobSeeker);
		return new SuccessResult("İş arayan eklendi");
	}

	@Override
	public Result update(JobSeeker jobSeeker) {
		// TODO Auto-generated method stub
		return new SuccessResult("İş arayan güncellendi");
	}

	@Override
	public Result delete(JobSeeker jobSeeker) {
		// TODO Auto-generated method stub
		jobSeekerDao.delete(jobSeeker);
		return new SuccessResult("İş arayan silindi");
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JobSeeker>>(jobSeekerDao.findAll());
	}

	@Override
	public DataResult<JobSeeker> getById(Integer id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.findById(id).get());
	}
	
	@Override
	public Result checkIfNationalIdExist(String nationalityId) {
		return jobSeekerDao.findByNationalityId(nationalityId).isEmpty() ? new SuccessResult()
				: new ErrorResult("Bu TC numarası ile kayıtlı başka kullanıcımız mevcut");
	}
	
	public Result emailVerification(String email) {
		
		return emailActivationService.check(email).isSuccess() ? new SuccessResult()
				: new ErrorResult();
	}

	/*@Override
	public DataResult<List<Job>> getJobSeekerCvDetails() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Job>>(this.jobSeekerDao.getJobSeekerCvDetails());
	}*/

	@Override
	public DataResult<List<JobSeekerCvDto>> getAllCv() {
		
		return new SuccessDataResult<List<JobSeekerCvDto>>(this.jobSeekerDao.findAll()
				.stream()
				.map(converter::convertToCv)
				.collect(Collectors.toList()),"Tüm kullanıcıların Cv bilgisi başarılı şekilde getirildi");
				
	}

	@Override
	public DataResult<List<JobSeekerCvDto>> getAllCvByJobSeeker_Id(int jobSeekerId) {
		
		return new SuccessDataResult<List<JobSeekerCvDto>>(this.jobSeekerDao.findById(jobSeekerId)
				.stream()
				.map(converter::convertToCv)
				.collect(Collectors.toList()),"Seçmiş olduğunuz iş arayanın Cv bilgisi başarılı şekilde getirildi");
	}

	

}
