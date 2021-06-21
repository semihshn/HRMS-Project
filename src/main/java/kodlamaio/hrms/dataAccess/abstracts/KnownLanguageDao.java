package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.KnownLanguage;

public interface KnownLanguageDao extends JpaRepository<KnownLanguage, Integer>{

}
