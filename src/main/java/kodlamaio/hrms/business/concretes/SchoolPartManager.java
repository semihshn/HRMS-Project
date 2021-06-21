package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SchoolPartService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SchoolPartDao;
import kodlamaio.hrms.entities.concretes.SchoolPart;

@Service
public class SchoolPartManager implements SchoolPartService{

private SchoolPartDao schoolPartDao;
	
	public SchoolPartManager(SchoolPartDao schoolPartDao) {
		this.schoolPartDao = schoolPartDao;
	}

	@Override
	public Result add(SchoolPart schoolPart) {
		// TODO Auto-generated method stub
		this.schoolPartDao.save(schoolPart);
		return new SuccessResult("Yeni okul bölümü eklendi");
	}

	@Override
	public Result update(SchoolPart schoolPart) {
		// TODO Auto-generated method stub
		return new SuccessResult("Okul bölümü güncellendi");
	}

	@Override
	public Result delete(SchoolPart schoolPart) {
		// TODO Auto-generated method stub
		return new SuccessResult("Okul bölümü silindi");
	}

	@Override
	public DataResult<List<SchoolPart>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<SchoolPart>>(schoolPartDao.findAll());
	}

	@Override
	public DataResult<SchoolPart> get(int id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<SchoolPart>(this.schoolPartDao.findById(id).get());
	}
	
}
