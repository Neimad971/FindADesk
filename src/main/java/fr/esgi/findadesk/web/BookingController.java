package fr.esgi.findadesk.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.esgi.findadesk.domain.Booking;
import fr.esgi.findadesk.domain.User;
import fr.esgi.findadesk.domain.Workspace;
import fr.esgi.findadesk.repository.IBookingRepository;
import fr.esgi.findadesk.repository.IUserRepository;
import fr.esgi.findadesk.repository.IWorkspaceRepository;

@RestController
@RequestMapping("/bookings")
public class BookingController {

	@Autowired
	private IBookingRepository bookingRepository;

	@Autowired
	private IUserRepository userRepository;

	@Autowired
	private IWorkspaceRepository workspaceRepository;

	public void setBookingRepository(IBookingRepository bookingRepository) {
		this.bookingRepository = bookingRepository;
	}

	public void setUserRepository(IUserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public void setWorkspaceRepository(IWorkspaceRepository workspaceRepository) {
		this.workspaceRepository = workspaceRepository;
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public Booking create(@RequestBody Booking booking,
			@PathVariable Integer userId, @PathVariable Integer workspaceId) {
		// booking.setUser(userRepository.findOne(userId));
		// booking.setWorkspace(workspaceRepository.findOne(workspaceId));
		return bookingRepository.save(booking);
	}

	@RequestMapping(value = "/save/{userId}/{workspaceId}/{begin}/{end}/{dateBooking}/{price}", method = RequestMethod.GET)
	public List<Booking> saveBooking(@PathVariable Integer userId,
			@PathVariable Integer workspaceId,
			@PathVariable @DateTimeFormat(iso = ISO.DATE) String begin,
			@PathVariable @DateTimeFormat(iso = ISO.DATE) String end,
			@PathVariable @DateTimeFormat(iso = ISO.DATE) String dateBooking,
			@PathVariable double price) {

		User u = new User();
		u = userRepository.findOne(userId);

		Workspace w = new Workspace();
		w = workspaceRepository.findOne(workspaceId);
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date beginDate = null;
		Date endDate = null;
		Date bookingDate = null;
	 
		try {
	 
			beginDate = formatter.parse(begin);
			endDate = formatter.parse(end);
			bookingDate = formatter.parse(dateBooking);
	 
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Booking b = bookingRepository.save(new Booking(beginDate, endDate, bookingDate, price, u, w));

		ArrayList<Booking> bookings = new ArrayList<Booking>();

		if (b == null) {
			return bookings;
		}

		bookings.add(b);

		return bookings;
	}
	
	@RequestMapping(value = "/delete/{bookingId}", method = RequestMethod.GET)
	public void deleteBooking(@PathVariable Integer bookingId) {
		
		bookingRepository.delete(bookingId);
	}

}
