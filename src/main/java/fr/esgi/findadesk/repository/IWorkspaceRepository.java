package fr.esgi.findadesk.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import fr.esgi.findadesk.domain.Workspace;


@RepositoryRestResource
public interface IWorkspaceRepository extends CrudRepository<Workspace, Integer>{
	
	@Transactional
	public List<Workspace> findAll();
}
