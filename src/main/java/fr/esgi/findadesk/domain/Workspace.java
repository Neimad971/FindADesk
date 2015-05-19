package fr.esgi.findadesk.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.joda.time.DateTime;

@Entity
@Table(name = "workspace")
public class Workspace 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;
	
	@NotNull
	private String type;
	
	@NotNull
	private double price;
	
	@NotNull
	private int seatsNumber;
	
	@NotNull
	private DateTime availableDate;

	@NotNull
	private String description;
	
	@NotNull
	private String bookedByUser;

	
	public String getId() 
	{
		return id;
	}

	
	public void setId(String id) 
	{
		this.id = id;
	}

	
	public String getType() 
	{
		return type;
	}

	
	public void setType(String type) 
	{
		this.type = type;
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

	
	public DateTime getAvailableDate() 
	{
		return availableDate;
	}

	
	public void setAvailableDate(DateTime availableDate) 
	{
		this.availableDate = availableDate;
	}

	
	public String getDescription() 
	{
		return description;
	}

	
	public void setDescription(String description) 
	{
		this.description = description;
	}


	public String getBookedByUser() 
	{
		return bookedByUser;
	}


	public void setBookedByUser(String bookedByUser) 
	{
		this.bookedByUser = bookedByUser;
	}	
}