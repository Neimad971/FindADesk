package fr.esgi.findadesk.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;

import fr.esgi.findadesk.domain.User;
import fr.esgi.findadesk.repository.IUserRepository;

@RestController
@RequestMapping("/users")
public class UserController 
{
	@Autowired
	private IUserRepository userRepository;

	
    public List<User> getFakeUsers() 
    {
		User su = new User();
	    su.setFirstName("Damien");
	    su.setLastName("TALBOT");
	    su.setEmail("damientalbot26@email.com");
	    su.setAddress("2 st...");
	    su.setPassword("encrypted pwd");
	    //su.setTelephone_number("9364204930");
	    
		
		List<User> users = Lists.newArrayList();
	    users.add(su);
    	
    	return users;
    }
	
    
    @RequestMapping(method = RequestMethod.GET)
    public List<User> getAllUsers() 
    {
    	//userRepository.save(getFakeUsers());
    	return userRepository.findAll();
    }
    
    
	@RequestMapping("/findOne")
	public User getUserByEmail(String email) 
	{
		return userRepository.findByEmail(email);
	}
}
