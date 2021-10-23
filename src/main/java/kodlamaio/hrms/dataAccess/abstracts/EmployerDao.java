package kodlamaio.hrms.dataAccess.abstracts;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer>{

	Employer findByUserId(int id);
	
	Optional<Employer> findByUser_EmailAndUser_Password(String email,String password);
	
}
