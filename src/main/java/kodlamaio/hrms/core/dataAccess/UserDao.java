package kodlamaio.hrms.core.dataAccess;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.core.entities.User;

public interface UserDao extends JpaRepository<User, Integer>{
	
	Optional<User> findByEmail(String email);
	
	Optional<User> findById(Integer userId);

}
