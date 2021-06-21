package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.School;

public interface SchoolService {

	Result add(School school);
	Result update(School school);
	Result delete(School school);
	
	DataResult<List<School>> getAll();
	DataResult<School> get(int id);
	
}
