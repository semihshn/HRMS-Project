package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.entities.concretes.Personal;

public interface PersonalService {

	void add();
	void update();
	void delete();
	
	List<Personal> getAll();
	Personal get(int id);
}
