package kodlamaio.hrms.entities.concretes;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="job_adverts")
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvert {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="description")
	private String description;
	
	@Column(name="min_salary")
	private int minSalary;
	
	@Column(name="max_salary")
	private int maxSalary;
	
	@Column(name="number_of_open_position")
	private int numberOfOpenPosition;
	
	/*@Column(name="created_at")
	private Date createdAt;*/
	
    @NotNull
    @Column(name = "created_at", columnDefinition = "Date default CURRENT_DATE")
    private final LocalDateTime createdAt = LocalDateTime.now();
	
	@Column(name="application_deadline")
	private LocalDateTime applicationDeadline;

	@Column(name="is_active")
	private boolean isActive;
	
	//targetEntity = İlişkiyi hangi entity ile kuracağını belirtiyoruz
	@ManyToOne(targetEntity = Employer.class)
	@JoinColumn(name="employer_id")
	private Employer employer;
	
	/*@OneToOne()
    @JoinColumn(name = "employer_id", referencedColumnName = "id")
    private Employer employer;*/
	
	@ManyToOne
	@JoinColumn(name="job_position_id")
	private Job job;
	
	@ManyToOne
	@JoinColumn(name="city_id")
	private City city;
	
	/*@OneToOne()
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    private City city;*/

}
