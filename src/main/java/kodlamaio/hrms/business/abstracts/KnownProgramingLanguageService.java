package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.KnownProgramingLanguage;

public interface KnownProgramingLanguageService {

	Result add(KnownProgramingLanguage knownProgramingLanguage);
	Result update(KnownProgramingLanguage knownProgramingLanguage);
	Result delete(KnownProgramingLanguage knownProgramingLanguage);
	
	DataResult<List<KnownProgramingLanguage>> getAll();
	DataResult<KnownProgramingLanguage> get(int id);
	
}
