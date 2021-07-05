package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.KnownLanguageService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.KnownLanguageDao;
import kodlamaio.hrms.entities.concretes.KnownLanguage;

@Service
public class KnownLanguageManager implements KnownLanguageService{

	private KnownLanguageDao knownLanguageDao;
	
	@Autowired
	public KnownLanguageManager(KnownLanguageDao knownLanguageDao) {
		this.knownLanguageDao = knownLanguageDao;
	}

	@Override
	public Result add(KnownLanguage knownLanguage) {
		// TODO Auto-generated method stub
		this.knownLanguageDao.save(knownLanguage);
		return new SuccessResult("İşveren kaydı eklendi");
	}

	@Override
	public Result update(KnownLanguage knownLanguage) {
		// TODO Auto-generated method stub
		return new SuccessResult("İşveren kaydı güncellendi");
	}

	@Override
	public Result delete(KnownLanguage knownLanguage) {
		// TODO Auto-generated method stub
		return new SuccessResult("İşveren kaydı silindi");
	}

	@Override
	public DataResult<List<KnownLanguage>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<KnownLanguage>>(this.knownLanguageDao.findAll());
	}

	@Override
	public DataResult<KnownLanguage> getById(Integer id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<KnownLanguage>(this.knownLanguageDao.findById(id).get());
	}
	
}
