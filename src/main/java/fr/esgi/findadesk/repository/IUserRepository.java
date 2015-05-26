package fr.esgi.findadesk.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import fr.esgi.findadesk.domain.User;


@RepositoryRestResource
public interface IUserRepository extends CrudRepository<User, Integer>
{
	
	@Transactional
	public List<User> findAll();
	
	@Transactional
	public User findByEmail(String email);
}
