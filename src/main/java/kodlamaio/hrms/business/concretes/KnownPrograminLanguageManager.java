package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	private KnownProgramingLanguageDao knownProgramingLanguageDao;
	
	@Autowired
	public KnownPrograminLanguageManager(KnownProgramingLanguageDao knownProgramingLanguageDao) {
		this.knownProgramingLanguageDao = knownProgramingLanguageDao;
	}

	@Override
	public Result add(KnownProgramingLanguage knownProgramingLanguage) {
		// TODO Auto-generated method stub
		this.knownProgramingLanguageDao.save(knownProgramingLanguage);
		return new SuccessResult("İşveren kaydı eklendi");
	}

	@Override
	public Result update(KnownProgramingLanguage knownProgramingLanguage) {
		// TODO Auto-generated method stub
		return new SuccessResult("İşveren kaydı güncellendi");
	}

	@Override
	public Result delete(KnownProgramingLanguage knownProgramingLanguage) {
		// TODO Auto-generated method stub
		return new SuccessResult("İşveren kaydı silindi");
	}

	@Override
	public DataResult<List<KnownProgramingLanguage>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<KnownProgramingLanguage>>(this.knownProgramingLanguageDao.findAll());
	}

	@Override
	public DataResult<KnownProgramingLanguage> get(int id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<KnownProgramingLanguage>(this.knownProgramingLanguageDao.findById(id).get());
	}
	
}
