package org.evgeny.bank_system.converters;

import org.evgeny.bank_system.dto.ClientDTO;
import org.evgeny.bank_system.entity.Client;

public class ClientConverter {

    public static ClientDTO toModel(Client client) {
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setFirstName(client.getFirstName());
        clientDTO.setLastName(client.getLastName());
        clientDTO.setPhoneNumber(client.getPhoneNumber());
        clientDTO.setMail(client.getMail());
        clientDTO.setBankName(client.getBank().getName());
        return clientDTO;
    }

    public static Client toClient(ClientDTO clientDTO) {
        Client client = new Client();
        client.setFirstName(clientDTO.getFirstName());
        client.setLastName(clientDTO.getLastName());
        client.setPhoneNumber(clientDTO.getPhoneNumber());
        client.setMail(clientDTO.getMail());
        return client;
    }
}
