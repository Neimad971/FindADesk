package fr.esgi.findadesk.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

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
	
	
	@Column(name = "address", nullable = false,length = 255)
	private String address;
	
	
	@Column(name = "email", nullable = false,length = 45)
	private String email;

	
	@Column(name = "password", nullable = false,length = 32)
	private String password;
	
	
	@Column(name = "telephone_number", nullable = true,length = 15)
	private String phoneNumber;
	
	
	@Column(name = "company", nullable = true,length = 32)
	private String company;
	
	
	@ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="booking", joinColumns=
    	@JoinColumn(name="user_id", referencedColumnName="user_id"),inverseJoinColumns=
    	@JoinColumn(name="workspace_id", referencedColumnName="workspace_id")
    )
	private List<Workspace> bookedWorkspace;
	

	public Integer getUserId() 
	{
		return userId;
	}

	public void setId(Integer userId) 
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

	public List<Workspace> getBookedWorkspace() 
	{
		return bookedWorkspace;
	}

	public void setBookedWorkspace(List<Workspace> bookedWorkspace) 
	{
		this.bookedWorkspace = bookedWorkspace;
	}
}