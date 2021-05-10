package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="employers")
public class Employer {
	
	@Id
	@GeneratedValue
	@Column(name="userid")
	private int userId;
	
	@Column(name="companyname")
	private String companyName;
	
	@Column(name="website")
	private String webSite;
	
	@Column(name="telephone")
	private String telephone;
	
	
	@Column(name="status")
	private boolean status;
	
	public Employer() {
		// TODO Auto-generated constructor stub
	}

	public Employer(int userId, String companyName, String webSite, String telephone, boolean status) {
		super();
		this.userId = userId;
		this.companyName = companyName;
		this.webSite = webSite;
		this.telephone = telephone;
		this.status = status;
	}
}
