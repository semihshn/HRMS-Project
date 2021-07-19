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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="jobseeker_school_informations")
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
	
	@ManyToOne
	@JoinColumn(name="jobseeker_id")
	private JobSeeker jobSeeker;
	
	@ManyToOne
	@JoinColumn(name="school_id")
	private School school;
	
	@ManyToOne
	@JoinColumn(name="school_part_id")
	private SchoolPart schoolPart;
	

}
