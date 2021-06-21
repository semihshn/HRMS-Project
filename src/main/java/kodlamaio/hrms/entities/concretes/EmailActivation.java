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
@Table(name="email_activations")
@AllArgsConstructor
@NoArgsConstructor
public class EmailActivation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="activation_code")
	private String activationCode;
	
	@Column(name="is_activated")
	private Boolean isActivated;

	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
}
