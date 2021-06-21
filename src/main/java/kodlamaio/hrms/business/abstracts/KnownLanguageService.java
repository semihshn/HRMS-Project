package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.KnownLanguage;

public interface KnownLanguageService {

	Result add(KnownLanguage knownLanguage);
	Result update(KnownLanguage knownLanguage);
	Result delete(KnownLanguage knownLanguage);
	
	DataResult<List<KnownLanguage>> getAll();
	DataResult<KnownLanguage> get(int id);
	
}
