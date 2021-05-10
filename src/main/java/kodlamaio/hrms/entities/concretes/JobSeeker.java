package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="jobseekers")
public class JobSeeker {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int userId;
	
	@Column(name="firstname")
	private String firstName;
	
	@Column(name="lastname")
	private String lastName;
	
	@Column(name="nationalityid")
	private char nationalityId; 
	
	@Column(name="yearofbirth")
	private String yearOfBirth;
	
	@Column(name="jobid")
	private int jobId;
	
	@Column(name="verifiedbysystem")
	private boolean verifiedBySystem;
	
	@Column(name="status")
	private boolean status;
	
	public JobSeeker() {
		// TODO Auto-generated constructor stub
	}

	public JobSeeker(int userId, String firstName, String lastName, char nationalityId, String yearOfBirth, int jobId,
			boolean verifiedBySystem, boolean status) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationalityId = nationalityId;
		this.yearOfBirth = yearOfBirth;
		this.jobId = jobId;
		this.verifiedBySystem = verifiedBySystem;
		this.status = status;
	}
}
