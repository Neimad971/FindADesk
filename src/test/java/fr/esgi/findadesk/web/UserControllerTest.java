package fr.esgi.findadesk.web;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.google.common.collect.Lists;

import fr.esgi.findadesk.domain.User;
import fr.esgi.findadesk.repository.IUserRepository;


public class UserControllerTest extends CommonControllerTest
{
	
	
    private List<User> userList;
    
  
    @Autowired
    private IUserRepository userRepository;
     

	public void setUserRepository(IUserRepository userRepository) 
	{
		this.userRepository = userRepository;
	}



	@Override
    @Before
    public void setup() throws Exception 
    {
        super.setup();
        
        this.userRepository.deleteAll();
        
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
        
        User user2 = new User();
        user2.setFirstName("Hussam");
        user2.setLastName("chaudhry");
        user2.setAddress("3 st...");
        user2.setEmail("chaudhry.hussam@gmail.com");
        user2.setPassword("encrypted pwd2");
        user2.setPhoneNumber("9364204931");
        user2.setCompany("brand new company2");
        //bookedWorkspaces
        
        
        userList.add(user1);
        userList.add(user2);
        
        userRepository.save(userList.get(0));
        userRepository.save(userList.get(1));
    }
    
    
    
    @Test
    public void readAllUsers() throws Exception
    {
    	mockMvc.perform(get("/users")
        		.content(this.json(new User()))
        		.contentType(contentType))
        		.andExpect(status().isOk())
        		.andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)))
        		.andExpect(MockMvcResultMatchers.jsonPath("$[0].userId", is(this.userList.get(0).getUserId().intValue())))
        		.andExpect(MockMvcResultMatchers.jsonPath("$[0].firstName", is(this.userList.get(0).getFirstName())))
        		.andExpect(MockMvcResultMatchers.jsonPath("$[0].lastName", is(this.userList.get(0).getLastName())))
        		.andExpect(MockMvcResultMatchers.jsonPath("$[0].address", is(this.userList.get(0).getAddress())))
        		.andExpect(MockMvcResultMatchers.jsonPath("$[0].email", is(this.userList.get(0).getEmail())))
        		.andExpect(MockMvcResultMatchers.jsonPath("$[0].password", is(this.userList.get(0).getPassword())))
        		.andExpect(MockMvcResultMatchers.jsonPath("$[0].phoneNumber", is(this.userList.get(0).getPhoneNumber())))
        		.andExpect(MockMvcResultMatchers.jsonPath("$[0].company", is(this.userList.get(0).getCompany())))
        		
    	
		    	.andExpect(MockMvcResultMatchers.jsonPath("$[1].userId", is(this.userList.get(1).getUserId().intValue())))
				.andExpect(MockMvcResultMatchers.jsonPath("$[1].firstName", is(this.userList.get(1).getFirstName())))
				.andExpect(MockMvcResultMatchers.jsonPath("$[1].lastName", is(this.userList.get(1).getLastName())))
				.andExpect(MockMvcResultMatchers.jsonPath("$[1].address", is(this.userList.get(1).getAddress())))
				.andExpect(MockMvcResultMatchers.jsonPath("$[1].email", is(this.userList.get(1).getEmail())))
				.andExpect(MockMvcResultMatchers.jsonPath("$[1].password", is(this.userList.get(1).getPassword())))
				.andExpect(MockMvcResultMatchers.jsonPath("$[1].phoneNumber", is(this.userList.get(1).getPhoneNumber())))
				.andExpect(MockMvcResultMatchers.jsonPath("$[1].company", is(this.userList.get(1).getCompany())));
    }
    
   
    /*
    @Test
    public void readOneUser() throws Exception
    {
    	mockMvc.perform(get("/users/" + userList.get(0).getId())
        		.content(this.json(new User()))
        		.contentType(contentType))
        		.andExpect(status().isOk())
        		.andExpect(MockMvcResultMatchers.jsonPath("$.id", is(this.userList.get(0).getId())))
        		.andExpect(MockMvcResultMatchers.jsonPath("$.firstName", is(this.userList.get(0).getFirstName())))
        		.andExpect(MockMvcResultMatchers.jsonPath("$.lastName", is(this.userList.get(0).getLastName())))
        		.andExpect(MockMvcResultMatchers.jsonPath("$.nickName", is(this.userList.get(0).getNickName())))
        		.andExpect(MockMvcResultMatchers.jsonPath("$.picture", is(this.userList.get(0).getPicture())))
        		.andExpect(MockMvcResultMatchers.jsonPath("$.email", is(this.userList.get(0).getEmail())))
        		.andExpect(MockMvcResultMatchers.jsonPath("$.gender", is(this.userList.get(0).getGender())))
        		.andExpect(MockMvcResultMatchers.jsonPath("$.profile", is(this.userList.get(0).getProfile())))
        		.andExpect(MockMvcResultMatchers.jsonPath("$.userParams.languageToImprove", is(this.userList.get(0).getUserParams().getLanguageToImprove())))
        		.andExpect(MockMvcResultMatchers.jsonPath("$.userParams.followedCountries", is(this.userList.get(0).getUserParams().getFollowedCountries())))
        		.andExpect(MockMvcResultMatchers.jsonPath("$.userParams.followedCategories", is(this.userList.get(0).getUserParams().getFollowedCategories())));
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
    	userToCreate.setId("20");
    	userToCreate.setFirstName("John");
    	userToCreate.setLastName("DOE");
    	userToCreate.setNickName("Joe");
    	userToCreate.setPicture("http link for picture");
    	userToCreate.setEmail("joe@email.com");
        //DateTime birthday = new DateTime();
        //user.setBirthday(new DateTime());
    	userToCreate.setGender("M");
    	userToCreate.setProfile("http link for profile");
        
        List<String> spokenLang = Lists.newArrayList();
        spokenLang.add("en");
        
        userToCreate.setCountry("America");
        userToCreate.setSpokenLanguages(spokenLang);
        
        List<String> followedCategories = Lists.newArrayList();
        followedCategories.add("health");
        
        List<String> followedCountries = Lists.newArrayList();
        followedCountries.add("Spain");
        
        List<String> languageToImprove = Lists.newArrayList();
        languageToImprove.add("Spanish");
        
        UserParams userParams = new UserParams();
        userParams.setFollowedCategories(followedCategories);
        userParams.setFollowedCountries(followedCountries);
        userParams.setLanguageToImprove(languageToImprove);
        userToCreate.setUserParams(userParams);
       
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
    	user.setNickName("newNickname");
    	String userJson = json(user);
    	
        this.mockMvc.perform(put("/users/" + userList.get(0).getId())
                .contentType(contentType)
                .content(userJson))
                .andExpect(status().isOk());
    }
    
    

    @Test
    public void deleteUser() throws Exception 
    {
    	User user = userList.get(1);
    	String userJson = json(user);
    	
        this.mockMvc.perform(put("/users/" + userList.get(1).getId())
                .contentType(contentType)
                .content(userJson))
                .andExpect(status().isOk());
    }
    
    
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
