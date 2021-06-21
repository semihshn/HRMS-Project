package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobSeekerContactInformation;

public interface JobSeekerContactInformationDao extends JpaRepository<JobSeekerContactInformation, Integer>{

}
