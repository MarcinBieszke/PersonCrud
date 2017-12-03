package com.handlers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mb.Person;
import com.service.PersonService;

@Controller
public class ControllerHandler {
	
	@Autowired
	private PersonService personService;
	
	@RequestMapping("/")
	public String getHomePage(){
		return "home";
	}
				
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addPersonPage(){
		return "add";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String savePerson(Person person){
		personService.savePerson(person);
		return "home";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deletePage(){
		return "delete";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String deletePerson(int id){
		personService.deletePerson(id);
		return "home";
	}
		
	@RequestMapping("/change")
	public String changeProfession(@PathParam(value = "id") int id,
					@PathParam(value = "profession") String profession, RedirectAttributes model){
		personService.changeProfession(id, profession);
		model.addAttribute("id", id);
		return "redirect:/show/{id}";
	}
	
	@RequestMapping("/show")
	public String showAllPeople(Model model){
		List<Person> peopleList = personService.getAllPerson();
		model.addAttribute("people",peopleList);
		return "showAll";
	}
	

	
	@RequestMapping("/show/{id}")
	public String showPerson(@PathVariable int id, Model model){
		Person person = personService.getPerson(id);
		model.addAttribute("person", person);
		return "show";
	}

}
