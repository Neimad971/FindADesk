package fr.esgi.findadesk.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;


@RepositoryRestResource
public interface UserDao extends CrudRepository<User, Integer>{
	
	@Transactional
	public List<User> findAll();
	
	@Transactional
	public User findByEmail(String email);
}
