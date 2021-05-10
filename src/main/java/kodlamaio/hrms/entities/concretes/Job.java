package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="jobs")
public class Job {

	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="jobname")
	private String JobName;
	
	public Job() {
		// TODO Auto-generated constructor stub
	}

	public Job(int id, String jobName) {
		super();
		this.id = id;
		JobName = jobName;
	}
}
