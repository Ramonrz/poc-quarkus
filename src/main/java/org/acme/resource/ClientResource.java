package org.acme.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.acme.dto.ClientDto;
import org.acme.service.ClientService;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/clients")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Tag(name = "Client")
public class ClientResource {

	@Inject
	ClientService clientService;

	@POST
	public Response create(ClientDto client) {
		return Response.status(Status.CREATED).entity(clientService.create(client)).build();
	}

	@GET
	public List<ClientDto> listAll() {
		return clientService.listAll();
	}

	@GET
	@Path("/{id}")
	public ClientDto byId(@PathParam("id") Long id) {
		return clientService.byId(id);
	}

	@PUT
	@Path("/{id}")
	public ClientDto update(@PathParam("id") Long id, ClientDto clientDto) {
		return clientService.update(id, clientDto);
	}

	@DELETE
	@Path("/{id}")
	public void delete(@PathParam("id") Long id) {
		clientService.delete(id);
	}

}