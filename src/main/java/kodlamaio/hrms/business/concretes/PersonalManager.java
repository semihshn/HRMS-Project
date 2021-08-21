package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.PersonalService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.PersonalDao;
import kodlamaio.hrms.entities.concretes.Personal;

@Service
public class PersonalManager implements PersonalService{

	private final PersonalDao personalDao;
	
	public PersonalManager(PersonalDao personalDao) {
		this.personalDao = personalDao;
	}

	@Override
	public Result add(Personal personal) {
		// TODO Auto-generated method stub
		this.personalDao.save(personal);
		return new SuccessResult("Personel eklendi");
	}

	@Override
	public Result update(Personal personal) {
		// TODO Auto-generated method stub
		this.personalDao.save(personal);
		return new SuccessResult("Personel eklendi");
	}

	@Override
	public Result delete(Integer id) {
		// TODO Auto-generated method stub
		this.personalDao.deleteById(id);
		return new SuccessResult("Personel eklendi");
	}

	@Override
	public DataResult<List<Personal>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Personal>>(personalDao.findAll());
	}

	@Override
	public DataResult<Personal> getById(Integer id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<Personal>(this.personalDao.findById(id).get());
	}

}
