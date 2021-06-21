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
@Table(name="known_languages")
@NoArgsConstructor
@AllArgsConstructor
public class KnownLanguage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="level")
	private int level;
	
	@ManyToOne
	@JoinColumn(name="job_seekers_id")
	private JobSeeker jobSeeker;
	
	@ManyToOne
	@JoinColumn(name="language_id")
	private Language language;

}
