package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Language;

public interface LanguageService {
	
	Result add(Language language);
	Result update(Language language);
	Result delete(Language language);
	
	DataResult<List<Language>> getAll();
	DataResult<Language> get(int id);
	
}
