package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.KnownProgramingLanguageService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.KnownProgramingLanguageDao;
import kodlamaio.hrms.entities.concretes.KnownProgramingLanguage;

@Service
public class KnownPrograminLanguageManager implements KnownProgramingLanguageService{

	private final KnownProgramingLanguageDao knownProgramingLanguageDao;
	
	public KnownPrograminLanguageManager(KnownProgramingLanguageDao knownProgramingLanguageDao) {
		this.knownProgramingLanguageDao = knownProgramingLanguageDao;
	}

	@Override
	public Result add(KnownProgramingLanguage knownProgramingLanguage) {
		// TODO Auto-generated method stub
		this.knownProgramingLanguageDao.save(knownProgramingLanguage);
		return new SuccessResult("İş arayan programlama dili bilgisi kaydı eklendi");
	}

	@Override
	public Result update(KnownProgramingLanguage knownProgramingLanguage) {
		// TODO Auto-generated method stub
		this.knownProgramingLanguageDao.save(knownProgramingLanguage);
		return new SuccessResult("İş arayan programlama dili bilgisi kaydı güncellendi");
	}

	@Override
	public Result delete(Integer id) {
		// TODO Auto-generated method stub
		this.knownProgramingLanguageDao.deleteById(id);
		return new SuccessResult("İş arayan programlama dili bilgisi kaydı silindi");
	}

	@Override
	public DataResult<List<KnownProgramingLanguage>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<KnownProgramingLanguage>>(this.knownProgramingLanguageDao.findAll());
	}

	@Override
	public DataResult<KnownProgramingLanguage> getById(Integer id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<KnownProgramingLanguage>(this.knownProgramingLanguageDao.findById(id).get());
	}
	
}
