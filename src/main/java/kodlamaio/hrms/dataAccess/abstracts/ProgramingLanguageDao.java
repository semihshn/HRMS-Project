package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.ProgramingLanguage;

public interface ProgramingLanguageDao extends JpaRepository<ProgramingLanguage, Integer>{

}
