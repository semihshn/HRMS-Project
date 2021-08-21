package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.LanguageService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.LanguageDao;
import kodlamaio.hrms.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService{
	
	private final LanguageDao languageDao;
	
	public LanguageManager(LanguageDao languageDao) {
		this.languageDao = languageDao;
	}

	@Override
	public Result add(Language language) {
		// TODO Auto-generated method stub
		this.languageDao.save(language);
		return new SuccessResult("Yabancı dil eklendi");
	}

	@Override
	public Result update(Language language) {
		// TODO Auto-generated method stub
		this.languageDao.save(language);
		return new SuccessResult("Yabancı dil güncellendi");
	}

	@Override
	public Result delete(Integer id) {
		// TODO Auto-generated method stub
		this.languageDao.deleteById(id);
		return new SuccessResult("Yabancı dil silindi");
	}

	@Override
	public DataResult<List<Language>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Language>>(languageDao.findAll());
	}

	@Override
	public DataResult<Language> getById(Integer id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<Language>(this.languageDao.findById(id).get());
	}
}
