package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.SchoolPart;

public interface SchoolPartService {

	Result add(SchoolPart schoolPart);
	Result update(SchoolPart schoolPart);
	Result delete(SchoolPart schoolPart);
	
	DataResult<List<SchoolPart>> getAll();
	DataResult<SchoolPart> get(int id);
	
}
