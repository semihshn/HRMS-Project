package kodlamaio.hrms.dataAccess.abstracts;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Personal;

public interface PersonalDao extends JpaRepository<Personal, Integer>{
	
	Personal findByUserId(int id);
	
	Optional<Personal> findByUser_EmailAndUser_Password(String email,String password);

}
