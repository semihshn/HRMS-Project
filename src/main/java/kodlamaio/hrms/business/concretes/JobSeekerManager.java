package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;


import kodlamaio.hrms.business.abstracts.EmailActivationService;
import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.business.abstracts.MernisActivationService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.business.adapters.mernisService.PersonForValidateFromMernisService;
import kodlamaio.hrms.core.utilities.business.BusinessRules;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.ErrorDataResult;
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

	private final JobSeekerDao jobSeekerDao;
	private final UserService userService;
	private final EmailActivationService emailActivationService;
	private final MernisActivationService mernisActivationService;
	private final Converter converter;
	
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

		/*Result result=BusinessRules.run(userService.checkIfEmailExist(jobSeeker.getUser().getEmail())
										,this.checkIfNationalIdExist(jobSeeker.getNationalityId())
										,mernisActivationService.check(new PersonForValidateFromMernisService())
										,this.emailVerification(jobSeeker.getUser().getEmail())
												);
		System.out.println(result.isSuccess());
		
		if (!result.isSuccess()) {
			return result;
		}*/
		
		this.jobSeekerDao.save(jobSeeker);
		return new SuccessResult("İş arayan eklendi");
	}

	@Override
	public Result update(JobSeeker jobSeeker) {
		// TODO Auto-generated method stub
		return new SuccessResult("İş arayan güncellendi");
	}

	@Override
	public Result delete(Integer id) {
		// TODO Auto-generated method stub
		jobSeekerDao.deleteById(id);
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

	@Override
	public DataResult<JobSeeker> findByUserId(int id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.findByUserId(id));
	}

	@Override
	public DataResult<JobSeeker> findByEmailAndPassword(String email, String password) {
		// TODO Auto-generated method stub
		Optional<JobSeeker> employer=this.jobSeekerDao.findByUser_EmailAndUser_Password(email, password);
		if (employer.isPresent()) {
			return new SuccessDataResult<JobSeeker>(employer.get());
		} else {
			return new ErrorDataResult<JobSeeker>("Bu email veya şifreye ait kullanıcı bulunamadı");
		}
	}

	@Override
	public DataResult<JobSeeker> getByUserId(int userId) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.findByUserId(userId));
	}

}
