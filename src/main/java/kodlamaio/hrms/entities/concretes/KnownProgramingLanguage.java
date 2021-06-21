package kodlamaio.hrms.entities.concretes;

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
@Table(name="known_programing_languages")
@NoArgsConstructor
@AllArgsConstructor
public class KnownProgramingLanguage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="job_seekers_id")
	private JobSeeker jobSeeker;
	
	@ManyToOne
	@JoinColumn(name="programing_language_id")
	private ProgramingLanguage programingLanguage;
	
}
