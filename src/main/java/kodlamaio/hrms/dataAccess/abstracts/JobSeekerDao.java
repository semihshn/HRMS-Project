package kodlamaio.hrms.dataAccess.abstracts;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobSeeker;


public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer>{
	
	Optional<JobSeeker> findByNationalityId(String nationalityId);
	
	/*@Query("Select new kodlamaio.hrms.entities.dtos.JobSeekerCvDto("
			+ "js.id,sc.name,sp.name,jss.universityStartDate,"
			+ "jss.universityGraduationDate,je.companyName,jp.jobName,"
			+ "je.startDate,je.endDate,kl,"
			+ "im.imageLink,jc.linkedinAdress,jc.githubAdress,"
			+ "kpl,jc.about) "
			+ "From JobSeeker js "
			+ "Inner Join js.jobExperiences je "
			+ "Inner Join js.knownLanguages kl "
			+ "Inner Join js.jobSeekerContactInformations jc "
			+ "Inner Join js.knownProgramingLanguages kpl "
			+ "Inner Join js.jobSeekerSchoolInformations jss "
			+ "Inner Join js.user us "
			+ "Inner Join us.images im "
			+ "Inner Join jss.school sc "
			+ "Inner Join sc.schoolPart sp "
			+ "Inner Join je.job jp")
	List<JobSeekerCvDto> getJobSeekerCvDetails();*/
	
	
	
}
