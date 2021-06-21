package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.KnownProgramingLanguage;

public interface KnownProgramingLanguageDao extends JpaRepository<KnownProgramingLanguage, Integer>{

}
