package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.MernisActivationService;
import kodlamaio.hrms.business.adapters.mernisService.MernisAdapter;
import kodlamaio.hrms.business.adapters.mernisService.PersonForValidateFromMernisService;
import kodlamaio.hrms.core.utilities.business.BusinessRules;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.MernisActivationDao;
import kodlamaio.hrms.entities.concretes.MernisActivation;

@Service
public class MernisActivationManager implements MernisActivationService{
	

	private final MernisActivationDao mernisActivationDao;
	private final MernisAdapter mernisAdapter;
	
	public MernisActivationManager(MernisActivationDao mernisActivationDao,MernisAdapter mernisAdapter) {
		super();
		this.mernisActivationDao = mernisActivationDao;
		this.mernisAdapter=mernisAdapter;
	}

	@Override
	public Result add(MernisActivation mernisActivation) {
		// TODO Auto-generated method stub
		this.mernisActivationDao.save(mernisActivation);
		return new SuccessResult("Mernis kaydı eklendi");
	}

	@Override
	public Result update(MernisActivation mernisActivation) {
		// TODO Auto-generated method stub
		this.mernisActivationDao.save(mernisActivation);
		return new SuccessResult("Mernis kaydı güncellendi");
	}

	@Override
	public Result delete(Integer id) {
		// TODO Auto-generated method stub
		this.mernisActivationDao.deleteById(id);
		return new SuccessResult("Mernis kaydı silindi");
	}

	@Override
	public DataResult<List<MernisActivation>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<MernisActivation>>(mernisActivationDao.findAll());
	}

	@Override
	public DataResult<MernisActivation> getById(Integer id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<MernisActivation>(this.mernisActivationDao.findById(id).get());
	}

	@Override
	public Result check(PersonForValidateFromMernisService personForValidateFromMernisService) {
		// TODO Auto-generated method stub
		Result result=BusinessRules.run(mernisAdapter.checkIfMernis(personForValidateFromMernisService)
						);

		if (result.isSuccess()) {
		return result;
		}
		
		return new SuccessResult("TC doğrulandı");
	}

}
