package org.acme.factory;

import java.util.ArrayList;
import java.util.List;

import org.acme.dto.ClientDto;
import org.acme.model.Client;

public class ClientFactory {

	public List<ClientDto> toClientDto(List<Client> clients) {
		List<ClientDto> list = new ArrayList<>();
		clients.forEach(client -> list.add(toClientDto(client)));
		return list;
	}

	public Client toClient(ClientDto client) {

		return Client.builder().id(client.getId()).name(client.getName()).taxIdNumber(client.getTaxIdNumber())
				.personType(client.getPersonType()).build();
	}

	public ClientDto toClientDto(Client client) {

		return ClientDto.builder().id(client.getId()).name(client.getName()).taxIdNumber(client.getTaxIdNumber())
				.personType(client.getPersonType()).creationDate(client.getCreationDate()).build();
	}

}