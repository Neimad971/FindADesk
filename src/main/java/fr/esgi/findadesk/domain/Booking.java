package fr.esgi.findadesk.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.joda.time.DateTime;

@Entity(name = "booking")
public class Booking 
{
	
	/*
	  `booking_id` int(15) NOT NULL,
	  `start_date` date NOT NULL,
	  `finish_date` date NOT NULL,
	  `date_booking` date NOT NULL,
	  `price_booking` double NOT NULL,
	  `id_user` int(11) NOT NULL,
	  `id_workspace` int(11) NOT NULL,
	  */
	
	@Id
	@Column(name = "booking_id", nullable = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer bookingId;
	
	
	private DateTime begin;
	
	
	private DateTime end;
	
	
	@Column(name = "user_id")
    private Integer userId;
	
	
	@ManyToOne(optional=false)
    @JoinColumn(name="user_id",referencedColumnName="user_id", insertable=false, updatable=false)
    private User user;
	
	
	@OneToOne(optional=false,cascade=CascadeType.ALL,mappedBy="booking",targetEntity=Workspace.class)
	private Workspace workspace;


	public Integer getBookingId() 
	{
		return bookingId;
	}


	public void setBookingId(Integer bookingId) 
	{
		this.bookingId = bookingId;
	}


	public DateTime getBegin() 
	{
		return begin;
	}


	public void setBegin(DateTime begin) 
	{
		this.begin = begin;
	}


	public DateTime getEnd() 
	{
		return end;
	}


	public void setEnd(DateTime end) 
	{
		this.end = end;
	}


	public Integer getUserId() 
	{
		return userId;
	}


	public void setUserId(Integer userId) 
	{
		this.userId = userId;
	}


	public User getUser() 
	{
		return user;
	}


	public void setUser(User user) 
	{
		this.user = user;
	}


	public Workspace getWorkspace() 
	{
		return workspace;
	}


	public void setWorkspace(Workspace workspace) 
	{
		this.workspace = workspace;
	}
}