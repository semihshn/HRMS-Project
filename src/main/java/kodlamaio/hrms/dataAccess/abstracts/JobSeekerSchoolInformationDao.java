package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobSeekerSchoolInformation;

public interface JobSeekerSchoolInformationDao extends JpaRepository<JobSeekerSchoolInformation, Integer>{

}
