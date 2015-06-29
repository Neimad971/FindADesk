package fr.esgi.findadesk.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import fr.esgi.findadesk.domain.Booking;
import fr.esgi.findadesk.domain.User;
import fr.esgi.findadesk.domain.Workspace;
import fr.esgi.findadesk.repository.IBookingRepository;
import fr.esgi.findadesk.repository.IUserRepository;

public class BookingControllerTest extends CommonControllerTest
{
	
	
	@Autowired
	private IBookingRepository bookingRepository;	
	
	@Autowired
	private IUserRepository userRepository;	
	
	
	public void setBookingRepository(IBookingRepository bookingRepository) 
	{
		this.bookingRepository = bookingRepository;
	}
	
	
	public void setUserRepository(IUserRepository userRepository) 
	{
		this.userRepository = userRepository;
	}


	@Override
    @Before
    public void setup() throws Exception 
    {
        super.setup();
        
        bookingRepository.deleteAll();
    }
	
	
	@Test
    public void createBooking() throws Exception 
    {
    	User user = new User();
    	//user.setUserId(979);
    	user.setFirstName("Lionel");
    	user.setLastName("lienafa");
    	user.setAddress("4 st...");
    	user.setEmail("lienafa.lionel@gmail.com");
    	user.setPassword("encrypted pwd3");
    	user.setPhoneNumber("9364204937");
    	user.setCompany("brand new company3");
    	userRepository.save(user);
    	
    	
    	
    	Workspace wksp = new Workspace();
    	//wksp.setId(890);
        wksp.setDescription("description");
        wksp.setCountry("USA");
        wksp.setAddress("120 street something");
        wksp.setCity("LA");
        wksp.setZipCode("27000");
        //wksp.setTypeId(2L);
        wksp.setUserEmail("admin@gmail.com");
        
        
        
        Booking bookingToCreate = new Booking();
        bookingToCreate.setUser(user);
        bookingToCreate.setBegin(new Date());
        bookingToCreate.setEnd(new Date());
        bookingToCreate.setWorkspace(wksp);
        
        
    	
    	
        String bookingJson = json(bookingToCreate);
       
        this.mockMvc.perform(post("/bookings")
                .contentType(contentType)
                .content(bookingJson))
                .andExpect(status().isCreated());
    }
	
	
}
