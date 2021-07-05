package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.business.BusinessRules;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{
	
	private EmployerDao employerDao;
	private UserService userService;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao,UserService userService) {
		this.employerDao = employerDao;
		this.userService=userService;
	}

	@Override
	public Result add(Employer employer) {

		Result result=BusinessRules.run(
						this.employerEmailControl(employer),
						this.checkIfEmployerEmailExist(employer)
						);

		if (!result.isSuccess()) {
		return result;
		}
		
		
		this.employerDao.save(employer);
		return new SuccessResult("İşveren kaydı eklendi");
	}

	@Override
	public Result update(Employer employer) {
		// TODO Auto-generated method stub
		return new SuccessResult("İşveren kaydı güncellendi");
	}

	@Override
	public Result delete(Employer employer) {
		// TODO Auto-generated method stub
		employerDao.delete(employer);
		return new SuccessResult("İşveren kaydı silindi");
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll());
	}

	@Override
	public DataResult<Employer> getById(Integer id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<Employer>(this.employerDao.findById(id).get());
	}
	
	public Result employerEmailControl(Employer employer) {
		System.out.println(employer.getUser().getEmail());
		String[] emailSplit = employer.getUser().getEmail().split("@");
		
		if (!employer.getWebSite().contains(emailSplit[1])) {
			return new ErrorResult("E-posta adresi, web adresinin bir uzantısı olmalıdır. Örneğin: ad@AlanAdınız.com");
		}
		else {
			return new SuccessResult();
		}
	}
	
    public Result checkIfEmployerEmailExist(Employer employer) {
    	
    	return userService.checkIfEmailExist(employer.getUser().getEmail());
    	
    }
	
	

}
