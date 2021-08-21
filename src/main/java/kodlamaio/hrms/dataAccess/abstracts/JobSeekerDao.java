package kodlamaio.hrms.dataAccess.abstracts;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobSeeker;


public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer>{
	
	Optional<JobSeeker> findByNationalityId(String nationalityId);
	
}
