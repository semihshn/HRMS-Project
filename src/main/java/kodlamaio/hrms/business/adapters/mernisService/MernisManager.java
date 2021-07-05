package kodlamaio.hrms.business.adapters.mernisService;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessResult;

@Service
public class MernisManager implements MernisAdapter{

	@Override
	public Result checkIfMernis(PersonForValidateFromMernisService personForValidateFromMernisService) {
		// TODO Auto-generated method stub
		return new SuccessResult();
	}


}
