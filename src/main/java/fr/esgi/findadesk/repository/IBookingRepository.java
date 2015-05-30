package fr.esgi.findadesk.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import fr.esgi.findadesk.domain.Booking;
import fr.esgi.findadesk.domain.User;

public interface IBookingRepository extends CrudRepository<Booking, Integer> 
{
	@Transactional
	public List<Booking> findAll();
	
	@Transactional
	public List<Booking> findByUser(User userId);
}
