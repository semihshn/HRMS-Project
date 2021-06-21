package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.ProgramingLanguage;

public interface ProgramingLanguageService {

	Result add(ProgramingLanguage programingLanguage);
	Result update(ProgramingLanguage programingLanguage);
	Result delete(ProgramingLanguage programingLanguage);
	
	DataResult<List<ProgramingLanguage>> getAll();
	DataResult<ProgramingLanguage> get(int id);
	
}
