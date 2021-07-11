package kodlamaio.hrms.entities.dtos;

import java.util.List;

import kodlamaio.hrms.entities.concretes.Image;
import kodlamaio.hrms.entities.concretes.Job;
import kodlamaio.hrms.entities.concretes.JobExperience;
import kodlamaio.hrms.entities.concretes.JobSeekerContactInformation;
import kodlamaio.hrms.entities.concretes.JobSeekerSchoolInformation;
import kodlamaio.hrms.entities.concretes.KnownLanguage;
import kodlamaio.hrms.entities.concretes.KnownProgramingLanguage;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
@NoArgsConstructor
public class JobSeekerCvDto {
	
	public JobSeekerCvDto(
			int jobSeekerId, List<Image> images, Job job, 
			List<JobExperience> jobExperiences,
			JobSeekerContactInformation jobSeekerContactInformation,
			List<JobSeekerSchoolInformation> jobSeekerSchoolInformations, 
			List<KnownLanguage> knownLanguages,
			List<KnownProgramingLanguage> knownProgramingLanguages) {
		super();
		this.jobSeekerId = jobSeekerId;
		this.images = images;
		this.job = job;
		this.jobExperiences = jobExperiences;
		this.jobSeekerContactInformation = jobSeekerContactInformation;
		this.jobSeekerSchoolInformations = jobSeekerSchoolInformations;
		this.knownLanguages = knownLanguages;
		this.knownProgramingLanguages = knownProgramingLanguages;
	}
	
	int jobSeekerId;
    List<Image> images;
	Job job;
	List<JobExperience> jobExperiences;
	JobSeekerContactInformation jobSeekerContactInformation;
	List<JobSeekerSchoolInformation> jobSeekerSchoolInformations;
	List<KnownLanguage> knownLanguages;
	List<KnownProgramingLanguage> knownProgramingLanguages;
	
}
