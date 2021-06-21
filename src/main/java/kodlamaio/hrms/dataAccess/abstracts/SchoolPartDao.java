package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.SchoolPart;

public interface SchoolPartDao extends JpaRepository<SchoolPart, Integer>{

}
