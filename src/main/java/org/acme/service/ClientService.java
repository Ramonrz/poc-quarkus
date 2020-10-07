package org.acme.service;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.RequestScoped;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;

import org.acme.dto.ClientDto;
import org.acme.factory.ClientFactory;
import org.acme.model.Client;

@RequestScoped
public class ClientService {

	private ClientFactory clientFactory;

	@Transactional
	public ClientDto create(ClientDto client) {

		Client save = getClientFactory().toClient(client);
		Client.persist(save);
		return getClientFactory().toClientDto(save);
	}

	public List<ClientDto> listAll() {

		List<Client> clients = Client.listAll();
		return getClientFactory().toClientDto(clients);
	}

	public ClientDto byId(Long id) {

		Optional<Client> findById = Client.findByIdOptional(id);

		if (findById.isPresent()) {
			return getClientFactory().toClientDto(findById.get());
		}
		throw new NotFoundException();
	}

	@Transactional
	public ClientDto update(Long id, ClientDto clientDto) {

		Optional<Client> findById = Client.findByIdOptional(id);

		if (findById.isPresent()) {

			Client client = findById.get();
			client.setName(clientDto.getName());
			client.setPersonType(clientDto.getPersonType());
			client.setTaxIdNumber(clientDto.getTaxIdNumber());
			client.persist();
			return getClientFactory().toClientDto(client);
		}
		throw new NotFoundException();
	}

	@Transactional
	public void delete(Long id) {

		Optional<Client> findById = Client.findByIdOptional(id);

		if (findById.isPresent()) {
			findById.get().delete();
			return;
		}
		throw new NotFoundException();
	}

	protected ClientFactory getClientFactory() {
		if (clientFactory == null) {
			clientFactory = new ClientFactory();
		}
		return clientFactory;
	}

}