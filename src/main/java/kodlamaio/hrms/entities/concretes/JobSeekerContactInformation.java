package kodlamaio.hrms.entities.concretes;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="jobseeker_contact_informations")
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerContactInformation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="linkedin_adress")
	private String linkedinAdress;
	
	@Column(name="about")
	private String about;
	
	@Column(name="status")
	private boolean status;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "jobseeker_id", referencedColumnName = "id")
    private JobSeeker jobSeeker;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "school_id", referencedColumnName = "id")
    private School school;

}
