package com.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mb.Person;

@Repository
@Transactional
public class PersonDaoImp implements PersonDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void savePerson(Person person) {
		getSession().save(person);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> getAllPerson() {
		Query query = getSession().createQuery("from Person");
		return (List<Person> ) query.list();
	}

	@Override
	public Person getPerson(int id) {
		Query query = getSession().createQuery("from Person where id =:id");
		query.setParameter("id", id);
		return (Person) query.uniqueResult();
	}

	@Override
	public void deletePerson(int id) {
		Person person = getPerson(id);
			getSession().delete(person);
	}

	@Override
	public void changeProfession(int id, String profession) {
		Person person = getPerson(id);
		person.setProfession(profession);
	}
	
	@ExceptionHandler(NullPointerException.class)
	public String exceptionHandler(NullPointerException ex){
		ex.getMessage();
		return "home";
	}

}
