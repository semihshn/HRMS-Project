package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.PersonalService;
import kodlamaio.hrms.dataAccess.abstracts.PersonalDao;
import kodlamaio.hrms.entities.concretes.Personal;

@Service
public class PersonalManager implements PersonalService{

	private PersonalDao personalDao;
	
	public PersonalManager(PersonalDao personalDao) {
		this.personalDao = personalDao;
	}

	@Override
	public void add() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Personal> getAll() {
		// TODO Auto-generated method stub
		return personalDao.findAll();
	}

	@Override
	public Personal get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
