package kodlamaio.hrms.entities.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployerWithUserDto {
	
	private int id;
	private String companyName;
	private String webSite;
	private String telephone;
	private Boolean status;
	private String email;

	public EmployerWithUserDto(int id, String companyName, String webSite, String telephone, Boolean status,
			String email) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.webSite = webSite;
		this.telephone = telephone;
		this.status = status;
		this.email = email;
	}
	
}
