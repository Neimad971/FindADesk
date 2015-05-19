package fr.esgi.findadesk.domain;

import org.joda.time.DateTime;

public class Workspace 
{
	private String id;
	
	private String type;
	
	private double price;
	
	private int seatsNumber;
	
	private DateTime availableDate;

	private String description;
	
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