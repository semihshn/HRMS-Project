package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerService {
	void add();
	void update();
	void delete();
	
	List<Employer> getAll();
	Employer get(int id);
}
