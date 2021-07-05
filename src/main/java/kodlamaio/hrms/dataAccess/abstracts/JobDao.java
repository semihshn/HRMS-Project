package kodlamaio.hrms.dataAccess.abstracts;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Job;

public interface JobDao extends JpaRepository<Job, Integer> {

	Optional<Job> findByJobName(String jobName);
	
}
