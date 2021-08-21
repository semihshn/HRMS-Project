package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SchoolService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SchoolDao;
import kodlamaio.hrms.entities.concretes.School;

@Service
public class SchoolManager implements SchoolService{
	
	private final SchoolDao schoolDao;
	
	public SchoolManager(SchoolDao schoolDao) {
		this.schoolDao = schoolDao;
	}

	@Override
	public Result add(School school) {
		// TODO Auto-generated method stub
		this.schoolDao.save(school);
		return new SuccessResult("Yeni okul eklendi");
	}

	@Override
	public Result update(School school) {
		// TODO Auto-generated method stub
		this.schoolDao.save(school);
		return new SuccessResult("Okul güncellendi");
	}

	@Override
	public Result delete(Integer id) {
		// TODO Auto-generated method stub
		this.schoolDao.deleteById(id);
		return new SuccessResult("Okul bölümü silindi");
	}

	@Override
	public DataResult<List<School>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<School>>(schoolDao.findAll());
	}

	@Override
	public DataResult<School> getById(Integer id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<School>(this.schoolDao.findById(id).get());
	}

}
