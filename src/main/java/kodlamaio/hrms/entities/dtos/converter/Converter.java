package kodlamaio.hrms.entities.dtos.converter;

import org.springframework.stereotype.Component;

import kodlamaio.hrms.entities.concretes.JobSeeker;
import kodlamaio.hrms.entities.dtos.JobSeekerCvDto;

@Component
public class Converter {
	public JobSeekerCvDto convertToCv(JobSeeker from) {
		
		return new JobSeekerCvDto(from.getId(),
								from.getUser().getImages(),
								from.getJob(),
								from.getJobExperiences(),
								from.getJobSeekerContactInformations(),
								from.getJobSeekerSchoolInformations(),
								from.getKnownLanguages(),
								from.getKnownProgramingLanguages()
									);
	}

}
