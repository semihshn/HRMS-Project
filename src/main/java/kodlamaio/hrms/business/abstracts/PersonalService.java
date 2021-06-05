package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Personal;

public interface PersonalService {

	Result add(Personal personal);
	Result update(Personal personal);
	Result delete(Personal personal);
	
	DataResult<List<Personal>> getAll();
	DataResult<Personal> get(int id);
}
