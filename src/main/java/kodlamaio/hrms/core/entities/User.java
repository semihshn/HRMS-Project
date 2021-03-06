package kodlamaio.hrms.core.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kodlamaio.hrms.entities.concretes.EmailActivation;
import kodlamaio.hrms.entities.concretes.Image;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="users")
@NoArgsConstructor
@AllArgsConstructor
//@JsonIgnoreProperties({"hibernateLazyInitializer","handler","emailActivations","mernisActivations","employer","jobSeeker","personal"})
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@JsonIgnore
	@OneToMany(mappedBy  = "user")
	private List<EmailActivation> emailActivations;
	
	@JsonIgnore
	@OneToMany(mappedBy  = "user")
	private List<Image> images;
	
	@JsonIgnore
	@OneToOne(mappedBy = "user")
    private JobSeeker jobSeeker;
	
}
