package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.EmailActivation;

public interface EmailActivationDao extends JpaRepository<EmailActivation, Integer>{

}
