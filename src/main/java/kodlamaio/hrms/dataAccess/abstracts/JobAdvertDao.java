package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobAdvert;

public interface JobAdvertDao extends JpaRepository<JobAdvert, Integer>{

	List<JobAdvert> getByEmployerId(int employerId);
	
	List<JobAdvert> getByEmployerIdOrId(int employerId,int jobAdvertId);
	
	List<JobAdvert> getByIsActive(Boolean isActive);
	
}
