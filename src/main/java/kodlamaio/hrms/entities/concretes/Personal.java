package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="personals")
public class Personal {
	
	
	@Id
	@GeneratedValue
	@Column(name="userid")
	private int userId;
	
	@Column(name="firstname")
	private String firstName;
	
	@Column(name="lastname")
	private String lastName;
	
	@Column(name="status")
	private boolean status;
	
	public Personal() {
		// TODO Auto-generated constructor stub
	}

	public Personal(int userId, String firstName, String lastName, boolean status) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.status = status;
	}
	
}
