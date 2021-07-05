package kodlamaio.hrms.dataAccess.abstracts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

import kodlamaio.hrms.entities.concretes.EmailActivation;
import kodlamaio.hrms.entities.dtos.EmailActivationWithUserDto;

public interface EmailActivationDao extends JpaRepository<EmailActivation, Integer>{
	Optional<EmailActivation> findByActivationCode(String activationCode);
	
	@Query("Select new kodlamaio.hrms.entities.dtos.EmailActivationWithUserDto(e.id,u.email,e.activationCode,e.isActivated) From User u Inner Join u.emailActivations e Where u.email=:email")
	Optional<EmailActivationWithUserDto> findByEmail(String email);
}
