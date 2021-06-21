package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmailActivationService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmailActivationDao;
import kodlamaio.hrms.entities.concretes.EmailActivation;

@Service
public class EmailActivationManager implements EmailActivationService{

	private EmailActivationDao emailActivationDao;
	
	public EmailActivationManager(EmailActivationDao emailActivationDao) {
		super();
		this.emailActivationDao = emailActivationDao;
	}

	@Override
	public Result add(EmailActivation emailActivation) {
		// TODO Auto-generated method stub
		this.emailActivationDao.save(emailActivation);
		return new SuccessResult("E-mail eklendi");
	}

	@Override
	public Result update(EmailActivation emailActivation) {
		// TODO Auto-generated method stub
		return new SuccessResult("E-mail güncellendi");
	}

	@Override
	public Result delete(EmailActivation emailActivation) {
		// TODO Auto-generated method stub
		return new SuccessResult("E-mail silindi");
	}

	@Override
	public DataResult<List<EmailActivation>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<EmailActivation>>(emailActivationDao.findAll());
	}

	@Override
	public DataResult<EmailActivation> get(int id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<EmailActivation>(this.emailActivationDao.findById(id).get());
	}

}
