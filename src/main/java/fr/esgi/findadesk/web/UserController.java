package fr.esgi.findadesk.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.esgi.findadesk.domain.User;

@RestController
@RequestMapping("/users")
public class UserController 
{

	@RequestMapping(method = RequestMethod.GET)
    public List<User> getAllUsers() 
    {
		User su = new User();
	    su.setId("0");
	    su.setFirstName("Damien");
	    su.setLastName("TALBOT");
	    su.setEmail("damientalbot26@email.com");
		
		List<User> users = new ArrayList<User>();
	    users.add(su);
	    
		return  users;
    }
}
