package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ProgramingLanguageService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ProgramingLanguageDao;
import kodlamaio.hrms.entities.concretes.ProgramingLanguage;

@Service
public class ProgramingLanguageManager implements ProgramingLanguageService{

	private final ProgramingLanguageDao programingLanguageDao;
	
	public ProgramingLanguageManager(ProgramingLanguageDao programingLanguageDao) {
		this.programingLanguageDao = programingLanguageDao;
	}

	@Override
	public Result add(ProgramingLanguage programingLanguage) {
		// TODO Auto-generated method stub
		this.programingLanguageDao.save(programingLanguage);
		return new SuccessResult("Programlama dili eklendi");
	}

	@Override
	public Result update(ProgramingLanguage programingLanguage) {
		// TODO Auto-generated method stub
		this.programingLanguageDao.save(programingLanguage);
		return new SuccessResult("Programlama dili güncellendi");
	}

	@Override
	public Result delete(Integer id) {
		// TODO Auto-generated method stub
		this.programingLanguageDao.deleteById(id);
		return new SuccessResult("Programlama dili silindi");
	}

	@Override
	public DataResult<List<ProgramingLanguage>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<ProgramingLanguage>>(programingLanguageDao.findAll());
	}

	@Override
	public DataResult<ProgramingLanguage> getById(Integer id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<ProgramingLanguage>(this.programingLanguageDao.findById(id).get());
	}
	
}
