package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.entities.concretes.Job;

public interface JobService {
	void add();
	void update();
	void delete();
	
	List<Job> getAll();
	Job get(int id);
}
