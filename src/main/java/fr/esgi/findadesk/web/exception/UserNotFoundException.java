package fr.esgi.findadesk.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException
{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2817613337473802514L;
	

	public UserNotFoundException(Integer userId)
	{
		super("Could not find user with id " + userId + " .");
	}

}
