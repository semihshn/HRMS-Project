package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import kodlamaio.hrms.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="job_seekers")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","knownLanguage","jobExperience","knownProgramingLanguage","job"})
public class JobSeeker {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="nationality_id")
	private String nationalityId; 
	
	@Column(name="year_of_birth")
	private String yearOfBirth;
	
	@Column(name="status")
	private boolean status;
	
	/*@Column(name="job_wanted_id")
	private int jobWantedId;*/
	
	@OneToMany(mappedBy  = "jobSeeker")
	private List<KnownLanguage> knownLanguage;
	
	@OneToMany(mappedBy="jobSeeker")
	private List<JobExperience> jobExperience;
	
	@OneToMany(mappedBy  = "jobSeeker")
	private List<KnownProgramingLanguage> knownProgramingLanguage;
	
	@OneToOne()
    @JoinColumn(name = "job_wanted_id", referencedColumnName = "id")
    private Job job;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
	
    @OneToOne(mappedBy = "jobSeeker")
    private JobSeekerContactInformation jobSeekerContactInformation;
    
    @OneToOne(mappedBy = "jobSeeker")
    private JobSeekerSchoolInformation jobSeekerSchoolInformation;
}
