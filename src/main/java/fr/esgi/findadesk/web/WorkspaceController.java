package fr.esgi.findadesk.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.esgi.findadesk.domain.Workspace;
import fr.esgi.findadesk.repository.IWorkspaceRepository;

@RestController
public class WorkspaceController {

	@Autowired
	private IWorkspaceRepository workSpaceDao;

	@RequestMapping("/workspaces")
	public List<Workspace> getAllUsers() {
		return workSpaceDao.findAll();
	}

	@RequestMapping("/workspacesListing/{typeId}/{city}/{seats}/{minPrice}/{maxPrice}")
	public List<Workspace> getWorkspacesForListing(@PathVariable Long typeId,
			@PathVariable String city, @PathVariable int seats,
			@PathVariable double minPrice, @PathVariable double maxPrice) {
		return workSpaceDao.findWorkspacesForListing(typeId, city, seats, minPrice, maxPrice);
	}
}
