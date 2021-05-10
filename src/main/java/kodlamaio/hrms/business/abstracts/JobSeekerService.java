package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.entities.concretes.JobSeeker;

public interface JobSeekerService {
	
	void add();
	void update();
	void delete();
	
	List<JobSeeker> getAll();
	JobSeeker get(int id);
}
