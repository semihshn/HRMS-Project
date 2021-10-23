package kodlamaio.hrms.business.concretes;


import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.AuthenticationService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.business.abstracts.PersonalService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.entities.User;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.ErrorDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.entities.dtos.LoginDto;

@Service
public class AuthenticationManager implements AuthenticationService{
	
	private final UserService userService;
	private final EmployerService employerService;
	private final PersonalService personalService;
	private final JobSeekerService jobSeekerService;
	
	public AuthenticationManager(UserService userService,EmployerService employerService,PersonalService personalService,JobSeekerService jobSeekerService) {
		super();
		this.userService = userService;
		this.employerService = employerService;
		this.personalService = personalService;
		this.jobSeekerService = jobSeekerService;
	}

	@Override
	public DataResult<LoginDto> login(String email, String password) {
		// TODO Auto-generated method stub
		LoginDto user = new LoginDto();
		DataResult<User> temp=this.userService.findByEmailAndPassword(email, password);
		//.getEmail().isEmpty()&&!temp.getPassword().isEmpty()
		if (temp.isSuccess()) {
			user.setEmail(temp.getData().getEmail());
			user.setPassword(temp.getData().getPassword());
			user.setUserId(temp.getData().getId());
		}else {
			return new ErrorDataResult<LoginDto>("Kullanıcı adı veya şifre hatalı");
		}
		
		if(this.employerService.findByEmailAndPassword(email, password).isSuccess()) {
			user.setAuthority("employer");
		}else if(this.jobSeekerService.findByEmailAndPassword(email, password).isSuccess()) {
			user.setAuthority("jobseeker");
		}else if(this.personalService.findByEmailAndPassword(email, password).isSuccess()) {
			user.setAuthority("personal");
		}
		
		return new SuccessDataResult<LoginDto>(user,"Giriş başarılı");

		
		
		 
	}

}
