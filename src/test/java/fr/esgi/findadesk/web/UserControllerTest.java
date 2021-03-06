package fr.esgi.findadesk.web;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.google.common.collect.Lists;

import fr.esgi.findadesk.domain.Booking;
import fr.esgi.findadesk.domain.User;
import fr.esgi.findadesk.domain.Workspace;
import fr.esgi.findadesk.repository.IBookingRepository;
import fr.esgi.findadesk.repository.IUserRepository;
import fr.esgi.findadesk.repository.IWorkspaceRepository;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/*
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
*/


public class UserControllerTest extends CommonControllerTest
{
	
	
    private List<User> userList;
    
  
    @Autowired
    private IUserRepository userRepository;
    
    
    @Autowired
	private IBookingRepository bookingRepository;
    
    
    @Autowired
	private IWorkspaceRepository workspaceRepository;
     

	public void setUserRepository(IUserRepository userRepository) 
	{
		this.userRepository = userRepository;
	}
	
	
	public void setBookingRepository(IBookingRepository bookingRepository)
	{
		this.bookingRepository = bookingRepository;
	}
	
	
	public void setWorkspaceRepository(IWorkspaceRepository workspaceRepository)
	{
		this.workspaceRepository = workspaceRepository;
	}

	
	

	
	@Override
    @Before
    public void setup() throws Exception 
    {
        super.setup();
        
        userRepository.deleteAll();
        workspaceRepository.deleteAll();
        bookingRepository.deleteAll();
        
        userList =  Lists.newArrayList();
        
        User user1 = new User();
        user1.setFirstName("Damien");
        user1.setLastName("TALBOT");
        user1.setAddress("2 st...");
        user1.setEmail("damientalbot26@email.com");
        user1.setPassword("encrypted pwd");
        user1.setPhoneNumber("9364204930");
        user1.setCompany("brand new company");
        //bookedWorkspaces
        userRepository.save(user1);
        
        //BEGIN TEST
        Workspace wksp = new Workspace();
        wksp.setDescription("description");
        wksp.setCountry("USA");
        wksp.setAddress("120 street something");
        wksp.setCity("LA");
        wksp.setZipCode("27000");
        wksp.setTypeId(2L);
        wksp.setUserEmail("admin@gmail.com");
        workspaceRepository.save(wksp);
        
        
        Booking b1 = new Booking();
        b1.setUser(user1);
        b1.setBegin(new Date());
        b1.setEnd(new Date());
        b1.setWorkspace(wksp);
        bookingRepository.save(b1);
        
        List<Booking> bookings = Lists.newArrayList();
        bookings.add(b1);
        user1.setBookings(bookings);
        
        
        List<User> fromDb = userRepository.findAll(); //that's ok
        
        
      
        //END TEST
        
        /*User user2 = new User();
        user2.setFirstName("Hussam");
        user2.setLastName("chaudhry");
        user2.setAddress("3 st...");
        user2.setEmail("chaudhry.hussam@gmail.com");
        user2.setPassword("encrypted pwd2");
        user2.setPhoneNumber("9364204931");
        user2.setCompany("brand new company2");*/
        //bookedWorkspaces
        
        
        //userList.add(user1);
        //userList.add(user2);
        
        //userRepository.save(userList.get(0));
        //userRepository.save(userList.get(1));
    }
    
    
    @Test
    public void readAllUsers() throws Exception
    {
    	mockMvc.perform(get("/users")
        		.content(this.json(new User()))
        		.contentType(contentType))
        		.andExpect(status().isOk())
        		.andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)))
        		.andExpect(MockMvcResultMatchers.jsonPath("$[0].userId", is(this.userList.get(0).getUserId())))
        		.andExpect(MockMvcResultMatchers.jsonPath("$[0].firstName", is(this.userList.get(0).getFirstName())))
        		.andExpect(MockMvcResultMatchers.jsonPath("$[0].lastName", is(this.userList.get(0).getLastName())))
        		.andExpect(MockMvcResultMatchers.jsonPath("$[0].address", is(this.userList.get(0).getAddress())))
        		.andExpect(MockMvcResultMatchers.jsonPath("$[0].email", is(this.userList.get(0).getEmail())))
        		.andExpect(MockMvcResultMatchers.jsonPath("$[0].password", is(this.userList.get(0).getPassword())))
        		.andExpect(MockMvcResultMatchers.jsonPath("$[0].phoneNumber", is(this.userList.get(0).getPhoneNumber())))
        		.andExpect(MockMvcResultMatchers.jsonPath("$[0].company", is(this.userList.get(0).getCompany())));
        		
    	
		    /*	.andExpect(MockMvcResultMatchers.jsonPath("$[1].userId", is(this.userList.get(1).getUserId())))
				.andExpect(MockMvcResultMatchers.jsonPath("$[1].firstName", is(this.userList.get(1).getFirstName())))
				.andExpect(MockMvcResultMatchers.jsonPath("$[1].lastName", is(this.userList.get(1).getLastName())))
				.andExpect(MockMvcResultMatchers.jsonPath("$[1].address", is(this.userList.get(1).getAddress())))
				.andExpect(MockMvcResultMatchers.jsonPath("$[1].email", is(this.userList.get(1).getEmail())))
				.andExpect(MockMvcResultMatchers.jsonPath("$[1].password", is(this.userList.get(1).getPassword())))
				.andExpect(MockMvcResultMatchers.jsonPath("$[1].phoneNumber", is(this.userList.get(1).getPhoneNumber())))
				.andExpect(MockMvcResultMatchers.jsonPath("$[1].company", is(this.userList.get(1).getCompany())));*/
    }
    
   
    /*@Test
    public void readOneUser() throws Exception
    {
    	mockMvc.perform(get("/users/" + userList.get(0).getUserId())
        		.content(this.json(new User()))
        		.contentType(contentType))
        		.andExpect(status().isOk())
        		.andExpect(MockMvcResultMatchers.jsonPath("$.userId", is(this.userList.get(0).getUserId())))
        		.andExpect(MockMvcResultMatchers.jsonPath("$.firstName", is(this.userList.get(0).getFirstName())))
        		.andExpect(MockMvcResultMatchers.jsonPath("$.lastName", is(this.userList.get(0).getLastName())))
        		.andExpect(MockMvcResultMatchers.jsonPath("$.address", is(this.userList.get(0).getAddress())))
        		.andExpect(MockMvcResultMatchers.jsonPath("$.email", is(this.userList.get(0).getEmail())))
        		.andExpect(MockMvcResultMatchers.jsonPath("$.password", is(this.userList.get(0).getPassword())))
        		.andExpect(MockMvcResultMatchers.jsonPath("$.phoneNumber", is(this.userList.get(0).getPhoneNumber())))
        		.andExpect(MockMvcResultMatchers.jsonPath("$.company", is(this.userList.get(0).getCompany())));
    }
    
    
    
    @Test
    public void userNotFound() throws Exception 
    {
        mockMvc.perform(get("/users/10")
                .content(this.json(new User()))
                .contentType(contentType))
                .andExpect(status().isNotFound());
    }
    
    
    
    @Test
    public void createUser() throws Exception 
    {
    	User userToCreate = new User();
    	userToCreate.setFirstName("Lionel");
    	userToCreate.setLastName("lienafa");
    	userToCreate.setAddress("4 st...");
    	userToCreate.setEmail("lienafa.lionel@gmail.com");
    	userToCreate.setPassword("encrypted pwd3");
    	userToCreate.setPhoneNumber("9364204937");
    	userToCreate.setCompany("brand new company3");
    	
    	
        String userJson = json(userToCreate);
       
        this.mockMvc.perform(post("/users")
                .contentType(contentType)
                .content(userJson))
                .andExpect(status().isCreated());
    }
    
    
    
    @Test
    public void updateUser() throws Exception 
    {
    	User user = userList.get(0);
    	user.setAddress("newAddress");
    	String userJson = json(user);
    	
        this.mockMvc.perform(put("/users/" + userList.get(0).getUserId())
                .contentType(contentType)
                .content(userJson))
                .andExpect(status().isOk());
    }
    
    
    
    @Test
    public void deleteUser() throws Exception 
    {
    	User user = userList.get(1);
    	String userJson = json(user);
    	
        this.mockMvc.perform(delete("/users/" + userList.get(1).getUserId())
                .contentType(contentType)
                .content(userJson))
                .andExpect(status().isOk());
    }
    
    
    /*
    @Test
    public void readAllUserTopics() throws Exception 
    {
    	Topic topic1 = topicList.get(0);
    	String Topic1Json = json(topic1);
    	
    	Topic topic2 = topicList.get(1);
    	String Topic2Json = json(topic2);
    	
    	StringBuilder strBuilder = new StringBuilder();
    	strBuilder.append(Topic1Json);
    	strBuilder.append(",");
    	strBuilder.append(Topic2Json);
    	
    	this.mockMvc.perform(get("/users/" + userList.get(0).getId() + "/topics")
                .contentType(contentType)
                .content(strBuilder.toString()))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id", is(this.topicList.get(0).getId())))
        		.andExpect(MockMvcResultMatchers.jsonPath("$[0].label", is(this.topicList.get(0).getLabel())))
        		.andExpect(MockMvcResultMatchers.jsonPath("$[0].description", is(this.topicList.get(0).getDescription())))
        		.andExpect(MockMvcResultMatchers.jsonPath("$[0].duration", is(this.topicList.get(0).getDuration())))
        		.andExpect(MockMvcResultMatchers.jsonPath("$[0].whateverTopic", is(this.topicList.get(0).isWhateverTopic())))
        		.andExpect(MockMvcResultMatchers.jsonPath("$[0].categoryId", is(this.topicList.get(0).getCategoryId())))
        		.andExpect(MockMvcResultMatchers.jsonPath("$[0].userId", is(this.topicList.get(0).getUserId())))
                
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id", is(this.topicList.get(1).getId())))
				.andExpect(MockMvcResultMatchers.jsonPath("$[1].label", is(this.topicList.get(1).getLabel())))
				.andExpect(MockMvcResultMatchers.jsonPath("$[1].description", is(this.topicList.get(1).getDescription())))
				.andExpect(MockMvcResultMatchers.jsonPath("$[1].duration", is(this.topicList.get(1).getDuration())))
				.andExpect(MockMvcResultMatchers.jsonPath("$[1].whateverTopic", is(this.topicList.get(1).isWhateverTopic())))
				.andExpect(MockMvcResultMatchers.jsonPath("$[1].categoryId", is(this.topicList.get(1).getCategoryId())))
				.andExpect(MockMvcResultMatchers.jsonPath("$[1].userId", is(this.topicList.get(1).getUserId())));           
    }
    
    
    @Test
    public void readOneUserTopic() throws Exception 
    {
    	Topic topic1 = topicList.get(0);
    	String topic1Json = json(topic1);
    	
    	this.mockMvc.perform(get("/users/" + userList.get(0).getId() + "/topics/" + topicList.get(0).getId())
                .contentType(contentType)
                .content(topic1Json))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", is(this.topicList.get(0).getId())))
        		.andExpect(MockMvcResultMatchers.jsonPath("$.label", is(this.topicList.get(0).getLabel())))
        		.andExpect(MockMvcResultMatchers.jsonPath("$.description", is(this.topicList.get(0).getDescription())))
        		.andExpect(MockMvcResultMatchers.jsonPath("$.duration", is(this.topicList.get(0).getDuration())))
        		.andExpect(MockMvcResultMatchers.jsonPath("$.whateverTopic", is(this.topicList.get(0).isWhateverTopic())))
        		.andExpect(MockMvcResultMatchers.jsonPath("$.categoryId", is(this.topicList.get(0).getCategoryId())))
        		.andExpect(MockMvcResultMatchers.jsonPath("$.userId", is(this.topicList.get(0).getUserId())));
    }
    
    
    @Test
    public void topicNotBelongToUser() throws Exception 
    {
    	this.mockMvc.perform(get("/users/" + userList.get(1).getId() + "/topics/" + topicList.get(0).getId())
                 .content(this.json(new Topic()))
                 .contentType(contentType))
                 .andExpect(status().isNotFound());
    }
    */
}
