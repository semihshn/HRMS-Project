package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CityDao;
import kodlamaio.hrms.entities.concretes.City;

@Service
public class CityManager implements CityService{
	
	private CityDao cityDao;
	
	public CityManager(CityDao cityDao) {
		super();
		this.cityDao = cityDao;
	}

	@Override
	public Result add(City city) {
		// TODO Auto-generated method stub
		this.cityDao.save(city);
		return new SuccessResult("E-mail eklendi");
	}

	@Override
	public Result update(City city) {
		// TODO Auto-generated method stub
		return new SuccessResult("E-mail güncellendi");
	}

	@Override
	public Result delete(City city) {
		// TODO Auto-generated method stub
		return new SuccessResult("E-mail silindi");
	}

	@Override
	public DataResult<List<City>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<City>>(cityDao.findAll());
	}

	@Override
	public DataResult<City> get(int id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<City>(this.cityDao.findById(id).get());
	}

}
