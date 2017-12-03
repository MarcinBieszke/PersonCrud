package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.PersonDao;
import com.mb.Person;

@Service
public class PersonServiceImp implements PersonService{
	
	@Autowired
	PersonDao personDao;

	@Override
	public void savePerson(Person person) {
		personDao.savePerson(person);
	}

	@Override
	public List<Person> getAllPerson() {
		return personDao.getAllPerson();
	}

	@Override
	public Person getPerson(int id) {
		return personDao.getPerson(id);
	}

	@Override
	public void deletePerson(int id) {
		if(!(personDao.getPerson(id) == null)){
		personDao.deletePerson(id);
		}
	}

	@Override
	public void changeProfession(int id, String profession) {
		if(!(personDao.getPerson(id) == null)){
			personDao.changeProfession(id, profession);
		}
	
	}

}
