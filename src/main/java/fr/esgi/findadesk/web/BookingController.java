package fr.esgi.findadesk.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.esgi.findadesk.domain.Booking;
import fr.esgi.findadesk.repository.IBookingRepository;

@RestController
@RequestMapping("/bookings")
public class BookingController 
{
	
	@Autowired
	private IBookingRepository bookingRepository;

	
	
	public void setBookingRepository(IBookingRepository bookingRepository) 
	{
		this.bookingRepository = bookingRepository;
	}
	
	
	
	@RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Booking create(@RequestBody Booking booking) 
	{
		return bookingRepository.save(booking);
	}
	
	
	
}
