package fr.esgi.findadesk.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.esgi.findadesk.domain.Booking;
import fr.esgi.findadesk.repository.IBookingRepository;
import fr.esgi.findadesk.repository.IUserRepository;
import fr.esgi.findadesk.repository.IWorkspaceRepository;

@RestController
@RequestMapping("/bookings")
public class BookingController 
{
	
	@Autowired
	private IBookingRepository bookingRepository;
	
	
	@Autowired
	private IUserRepository userRepository;
	
	
	@Autowired
	private IWorkspaceRepository workspaceRepository;

	
	
	public void setBookingRepository(IBookingRepository bookingRepository) 
	{
		this.bookingRepository = bookingRepository;
	}
	
	
	public void setUserRepository(IUserRepository userRepository) 
	{
		this.userRepository = userRepository;
	}
	
	
	public void setWorkspaceRepository(IWorkspaceRepository workspaceRepository) 
	{
		this.workspaceRepository = workspaceRepository;
	}
	
	
	
	@RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Booking create(@RequestBody Booking booking, @PathVariable Integer userId, @PathVariable Integer workspaceId)  
	{
		//booking.setUser(userRepository.findOne(userId));
		//booking.setWorkspace(workspaceRepository.findOne(workspaceId));
		return bookingRepository.save(booking);
	}
	
	
	
}
