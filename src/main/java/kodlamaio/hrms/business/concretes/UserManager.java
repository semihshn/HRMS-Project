package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.User;

@Service
public class UserManager implements UserService{

	private UserDao userDao;
	
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public Result add(User user) {
		// TODO Auto-generated method stub
		this.userDao.save(user);
		return new SuccessResult("Kullanıcı eklendi");
	}

	@Override
	public Result update(User user) {
		// TODO Auto-generated method stub
		return new SuccessResult("Kullanıcı eklendi");
	}

	@Override
	public Result delete(User user) {
		// TODO Auto-generated method stub
		return new SuccessResult("Kullanıcı silindi");
	}

	@Override
	public DataResult<List<User>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<User>>(userDao.findAll());
	}

	@Override
	public DataResult<User> get(int id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<User>(this.userDao.findById(id).get());
	}

}
