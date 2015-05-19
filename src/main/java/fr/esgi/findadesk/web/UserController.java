package fr.esgi.findadesk.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.esgi.findadesk.domain.User;
import fr.esgi.findadesk.domain.UserDao;

@RestController
public class UserController 
{
	@Autowired
	private UserDao userDao;

	@RequestMapping("/users")
    public List<User> getAllUsers() 
    {
//		User su = new User();
//	    su.setId("0");
//	    su.setFirstName("Damien");
//	    su.setLastName("TALBOT");
//	    su.setEmail("damientalbot26@email.com");
//		
//		List<User> users = new ArrayList<User>();
//	    users.add(su);
	    
		return userDao.findAll();
    }
	
	@RequestMapping("/findOne")
	public User getUserByEmail(String email) {
		return userDao.findByEmail(email);
	}
}
