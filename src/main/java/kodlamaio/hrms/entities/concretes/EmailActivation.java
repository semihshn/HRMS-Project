package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import kodlamaio.hrms.core.entities.User;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name="email_activations")
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
	
	@Builder
	public EmailActivation(@NotNull final User user, @NotBlank @Size(max = 200) final String activationCode,
			@NotNull final boolean isActivated) {
		this.user = user;
		this.activationCode = activationCode;
		this.isActivated = isActivated;
	}

	@Builder
	public EmailActivation(@NotNull final User user, @NotBlank @Size(max = 200) final String activationCode) {
		this.user = user;
		this.activationCode = activationCode;
	}
}
