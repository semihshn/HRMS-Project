package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;
import java.util.Optional;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.dataAccess.UserDao;
import kodlamaio.hrms.core.entities.User;
import kodlamaio.hrms.core.utilities.business.BusinessRules;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.ErrorDataResult;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;

@Service
public class UserManager implements UserService{

	private final UserDao userDao;
	
	public UserManager(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public Result add(User user) {
		// TODO Auto-generated method stub
		Result result=BusinessRules.run();

		if (!result.isSuccess()) {
		return result;
		}
		
		this.userDao.save(user);
		return new SuccessResult("Kullanıcı eklendi");
	}

	@Override
	public Result update(User user) {
		// TODO Auto-generated method stub
		this.userDao.save(user);
		return new SuccessResult("Kullanıcı güncellendi");
	}

	@Override
	public Result delete(Integer id) {
		// TODO Auto-generated method stub
		this.userDao.deleteById(id);
		return new SuccessResult("Kullanıcı silindi");
	}

	@Override
	public DataResult<List<User>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<User>>(userDao.findAll());
	}

	@Override
	public DataResult<User> getById(Integer id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<User>(this.userDao.findById(id).get());
	}

	@Override
	public DataResult<User> getByEmailWithEmail(String email) {
		final Optional<User> user = userDao.findByEmail(email);

		if (user.isEmpty())
			return new ErrorDataResult<User>("Kullanıcı bulunamadı");

		return new SuccessDataResult<User>(user.get());
	}

	@Override
	public Result checkIfEmailExist(String email) {
		return userDao.findByEmail(email).isEmpty() ? new SuccessResult()
				: new ErrorResult("Bu email zaten kayıtlı");
	}

	@Override
	public DataResult<User> getByEmailWithUserId(int userId) {
		
		Optional<User> user = userDao.findById(userId);
		
		if (user.isEmpty())
			return new ErrorDataResult<User>("Kullanıcı bulunamadı");

		return new SuccessDataResult<User>(user.get());
	}

}
