package fr.esgi.findadesk.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.esgi.findadesk.domain.User;
import fr.esgi.findadesk.repository.IUserRepository;
import fr.esgi.findadesk.web.exception.UserNotFoundException;


@RestController
@RequestMapping("/users")
public class UserController 
{
	
	@Autowired
	private IUserRepository userRepository;
	
		
    public void setUserRepository(IUserRepository userRepository) 
    {
		this.userRepository = userRepository;
	}
	
    
    @RequestMapping(method = RequestMethod.GET)
    public List<User> getAllUsers() 
    {
    	return userRepository.findAll();
    }
    
    
    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public User getUserById(@PathVariable Integer userId)
	{
		User user = userRepository.findOne(userId);
		
		if(user == null)
		{
			throw new UserNotFoundException(userId);
		}
		
		return user;			
    }
    
    
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User user) 
	{
		return userRepository.save(user);
	}
    
    
    @RequestMapping(value = "/{userId}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
    public User updateUser(@PathVariable Integer userId, @RequestBody User user) 
	{	
		User userToUpdate = userRepository.findOne(userId);
		
		if(userToUpdate == null)
		{
			throw new UserNotFoundException(userId);
		}
		
		user.setId(userToUpdate.getUserId());
		
		return userRepository.save(user);
	}
	
    
	@RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable Integer userId) 
	{	
		User userToDelete = userRepository.findOne(userId);
		
		if(userToDelete == null)
		{
			throw new UserNotFoundException(userId);
		}
		
		userRepository.delete(userToDelete);
	}
}
