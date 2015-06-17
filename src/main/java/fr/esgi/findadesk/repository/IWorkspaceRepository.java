package fr.esgi.findadesk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import fr.esgi.findadesk.domain.Workspace;

@RepositoryRestResource
public interface IWorkspaceRepository extends
		CrudRepository<Workspace, Integer> {
	
	@Transactional
	public List<Workspace> findAll();

	@Query(value = "SELECT city FROM workspace GROUP BY city")
	public List<Workspace> findWorkspaceLocations();

	
	@Query(value = "SELECT w FROM workspace w WHERE w.typeId = :type AND w.city = :city AND w.seatsNumber = :seatsNumber "
			+ "AND w.price BETWEEN :minPrice AND :maxPrice")
	public List<Workspace> findWorkspacesForListing(@Param("type") Long type,
			@Param("city") String city, @Param("seatsNumber") int seatsNumber,
			@Param("minPrice") double minPrice,
			@Param("maxPrice") double maxPrice);
}
