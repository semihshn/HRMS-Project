package kodlamaio.hrms.entities.concretes;

import java.time.LocalDateTime;

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
public class JobSeekerSchoolInformation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="university_start_date")
	private LocalDateTime universityStartDate;
	
	@Column(name="university_graduation_date")
	private LocalDateTime universityGraduationDate;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "jobseeker_id", referencedColumnName = "id")
    private JobSeeker jobSeeker;

}
