package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.City;

public interface CityService {
	
	Result add(City city);
	Result update(City city);
	Result delete(City city);
	
	DataResult<List<City>> getAll();
	DataResult<City> get(int id);
	
}
