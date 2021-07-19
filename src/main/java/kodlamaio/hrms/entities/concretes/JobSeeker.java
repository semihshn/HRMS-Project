package kodlamaio.hrms.entities.concretes;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import kodlamaio.hrms.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="job_seekers")
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobSeekerContactInformations","jobExperiences","knownLanguages","knownProgramingLanguages","jobSeekerSchoolInformations"})
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
	
	@ManyToOne()
    @JoinColumn(name = "job_wanted_id")
    private Job job;
	
	/*@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "job_wanted_id", referencedColumnName = "id")
    private Job job;*/
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
	
	@JsonIgnore
    @OneToOne(mappedBy = "jobSeeker")
    private JobSeekerContactInformation jobSeekerContactInformations;
	
    @JsonIgnore
    @OneToMany(mappedBy="jobSeeker")
    private List<JobExperience> jobExperiences;
    
    @JsonIgnore
    @OneToMany(mappedBy="jobSeeker")
    private List<KnownLanguage> knownLanguages;
    
    @JsonIgnore
    @OneToMany(mappedBy="jobSeeker")
    private List<KnownProgramingLanguage> knownProgramingLanguages;
    
    @JsonIgnore
    @OneToMany(mappedBy="jobSeeker")
    private List<JobSeekerSchoolInformation> jobSeekerSchoolInformations;

}
