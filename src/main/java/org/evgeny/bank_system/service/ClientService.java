package org.evgeny.bank_system.service;

import org.evgeny.bank_system.dto.ClientDTO;
import org.evgeny.bank_system.entity.BankAccount;
import org.evgeny.bank_system.entity.Client;

import java.util.List;

public interface ClientService {
    ClientDTO getAllInfoAboutClient(Long id);
    ClientDTO getClientByBankAccountId(long id);
    List<ClientDTO> getAllClientsByBankName(String bankName);
    void addClient(ClientDTO clientDTO);
    void deleteClient(long id);
}
