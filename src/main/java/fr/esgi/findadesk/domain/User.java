package fr.esgi.findadesk.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "user")
public class User 
{
	
	
	@Id
	@Column(name = "user_id", nullable = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer userId;

	
	@Column(name = "first_name", nullable = false,length = 32)
	private String firstName;

	
	@Column(name = "last_name", nullable = false,length = 32)
	private String lastName;
	
	
	@Column(name = "address", nullable = true,length = 255)
	private String address;
	
	
	@Column(name = "email", nullable = false,length = 45)
	private String email;

	
	@Column(name = "password", nullable = false,length = 32)
	private String password;
	
	
	@Column(name = "telephone_number", nullable = true,length = 15)
	private String phoneNumber;
	
	
	@Column(name = "company", nullable = true,length = 32)
	private String company;
	
	
    @SuppressWarnings("rawtypes")
	@OneToMany(mappedBy="user",targetEntity=Booking.class,fetch=FetchType.EAGER)
    @JsonIgnore
    private List<Booking> bookings;
    
    public User() {
    	
    }
    
	public User(String firstName, String lastName, String address,
			String email, String password, String phoneNumber, String company) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.company = company;
	}

	public Integer getUserId() 
	{
		return userId;
	}

	public void setUserId(Integer userId) 
	{
		this.userId = userId;
	}

	public String getFirstName() 
	{
		return firstName;
	}

	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}

	public String getLastName() 
	{
		return lastName;
	}

	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}

	public String getAddress() 
	{
		return address;
	}

	public void setAddress(String address) 
	{
		this.address = address;
	}

	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}

	public String getPhoneNumber() 
	{
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) 
	{
		this.phoneNumber = phoneNumber;
	}

	public String getCompany() 
	{
		return company;
	}

	public void setCompany(String company) 
	{
		this.company = company;
	}


	@SuppressWarnings("rawtypes")
	public List<Booking> getBookings()
	{
		return bookings;
	}

	
	@SuppressWarnings("rawtypes")
	public void setBookings(List<Booking> bookings)
	{
		this.bookings = bookings;
	}
}