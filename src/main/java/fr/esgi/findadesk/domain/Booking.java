package fr.esgi.findadesk.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity(name = "booking")
public class Booking 
{

	
	@Id
	@Column(name = "booking_id", nullable = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer bookingId;
	
	
	@Column(name = "start_date")
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date begin;
	
	
	@Column(name = "finish_date")
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date end;
	
	
	@ManyToOne
    @JoinColumn(name="user_id", nullable=false, referencedColumnName="user_id")
    private User user;
	
	
	
	@ManyToOne
    @JoinColumn(name="workspace_id", nullable=false, referencedColumnName="workspace_id")
	private Workspace workspace;


	public Integer getBookingId() 
	{
		return bookingId;
	}


	public void setBookingId(Integer bookingId) 
	{
		this.bookingId = bookingId;
	}


	public Date getBegin() 
	{
		return begin;
	}


	public void setBegin(Date begin) 
	{
		this.begin = begin;
	}


	public Date getEnd() 
	{
		return end;
	}


	public void setEnd(Date end) 
	{
		this.end = end;
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