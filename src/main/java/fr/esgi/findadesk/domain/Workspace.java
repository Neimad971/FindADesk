package fr.esgi.findadesk.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "workspace")
public class Workspace 
{
	
	
	@Id
	@Column(name = "workspace_id", nullable = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer workspaceId;
	
	
	@Column(name = "workspace_type_id", nullable = false)
	private Long typeId;
	
	
	@Column(name = "price", nullable = false)
	private double price;
	
	
	@Column(name = "seats_number", nullable = false)
	private int seatsNumber;
	
	
	@Column(name = "description", nullable = false, length = 255)
	private String description;
	
	@Column(name = "email_admin", nullable = false, length = 32)
	private String userEmail;
	
	
	@Column(name = "address", nullable = false, length = 50)
	private String address;
	
	
	@Column(name = "city", nullable = false, length = 32)
	private String city;
	
	
	@Column(name = "cp", nullable = false, length = 5)
	private String zipCode;
	
	
	@Column(name = "country", nullable = false, length = 20)
	private String Country;
	
	
	@Column(name = "longitude", nullable = false)
	private double longitude;
	
	
	@Column(name = "latitude", nullable = false)
	private double latitude;
	
	
	//@OneToMany(mappedBy="workspace",targetEntity=Booking.class,fetch=FetchType.EAGER)
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name="workspace_id")
	@JsonIgnore
    private List<Booking> bookings;
	
	
	public Integer getWorkspaceId() 
	{
		return workspaceId;
	}

	
	public void setId(Integer workspaceId) 
	{
		this.workspaceId = workspaceId;
	}


	public Long getTypeId() 
	{
		return typeId;
	}


	public void setTypeId(Long typeId) 
	{
		this.typeId = typeId;
	}


	public double getPrice() 
	{
		return price;
	}

	
	public void setPrice(double price) 
	{
		this.price = price;
	}

	
	public int getSeatsNumber() 
	{
		return seatsNumber;
	}

	
	public void setSeatsNumber(int seatsNumber) 
	{
		this.seatsNumber = seatsNumber;
	}

	
	public String getDescription() 
	{
		return description;
	}

	
	public void setDescription(String description) 
	{
		this.description = description;
	}


	public String getUserEmail() 
	{
		return userEmail;
	}


	public void setUserEmail(String userEmail) 
	{
		this.userEmail = userEmail;
	}


	public String getAddress() 
	{
		return address;
	}


	public void setAddress(String address) 
	{
		this.address = address;
	}


	public String getCity() 
	{
		return city;
	}


	public void setCity(String city) 
	{
		this.city = city;
	}


	public String getZipCode() 
	{
		return zipCode;
	}


	public void setZipCode(String zipCode) 
	{
		this.zipCode = zipCode;
	}


	public String getCountry() 
	{
		return Country;
	}


	public void setCountry(String country) 
	{
		Country = country;
	}


	public double getLongitude() 
	{
		return longitude;
	}


	public void setLongitude(double longitude) 
	{
		this.longitude = longitude;
	}


	public double getLatitude() 
	{
		return latitude;
	}


	public void setLatitude(double latitude) 
	{
		this.latitude = latitude;
	}


	public List<Booking> getBookings() 
	{
		return bookings;
	}


	public void setBookings(List<Booking> bookings) 
	{
		this.bookings = bookings;
	}
}