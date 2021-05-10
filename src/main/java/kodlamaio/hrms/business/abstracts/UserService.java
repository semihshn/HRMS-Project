package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.entities.concretes.User;

public interface UserService {

	void add();
	void update();
	void delete();
	
	List<User> getAll();
	User get(int id);
}
