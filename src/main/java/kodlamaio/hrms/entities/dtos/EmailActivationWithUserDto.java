package kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailActivationWithUserDto {

	private int id;
	private String email;
	private String activationCode;
	private Boolean isActivated;
	
}
