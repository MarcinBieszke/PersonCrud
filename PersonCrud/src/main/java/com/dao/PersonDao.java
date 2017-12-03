package com.dao;

import java.util.List;

import com.mb.Person;

public interface PersonDao {
	
	public void savePerson(Person person);
	public List<Person> getAllPerson();
	public Person getPerson(int id);
	public void deletePerson(int id);
	public void changeProfession(int id, String profession);
	

}
