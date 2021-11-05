package org.evgeny.bank_system.service.impl;

import org.evgeny.bank_system.converters.ClientConverter;
import org.evgeny.bank_system.dto.ClientDTO;
import org.evgeny.bank_system.entity.Bank;
import org.evgeny.bank_system.entity.BankAccount;
import org.evgeny.bank_system.entity.Client;
import org.evgeny.bank_system.exception_handling.NoElementsException;
import org.evgeny.bank_system.repository.BankAccountRepository;
import org.evgeny.bank_system.repository.BankRepository;
import org.evgeny.bank_system.repository.ClientRepository;
import org.evgeny.bank_system.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private BankRepository bankRepository;

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Override
    public ClientDTO getAllInfoAboutClient(Long id) {
        if (clientRepository.findById(id).isEmpty()) {
            throw new NoElementsException("No client with id = " + id);
        }
        return ClientConverter.toModel(clientRepository.getById(id));
    }

    @Override
    public List<ClientDTO> getAllClientsByBankName(String bankName) {
        if (bankRepository.findByName(bankName) == null) {
            throw new NoElementsException("No bank with name = " + bankName);
        }
        return clientRepository.findAllByBankName(bankName).stream().map(ClientConverter::toModel).collect(Collectors.toList());
    }

    @Override
    public void addClient(ClientDTO clientDTO) {
        Bank bank = bankRepository.findByName(clientDTO.getBankName());
        Client client = ClientConverter.toClient(clientDTO);
        if (bank != null) {
            client.setBank(bank);
            clientRepository.save(client);
        }
        else {
            Bank bankToSave = new Bank();
            bankToSave.setName(clientDTO.getBankName());
            bankRepository.save(bankToSave);
            client.setBank(bankToSave);
            clientRepository.save(client);
        }
    }

    @Transactional
    @Override
    public void deleteClient(long id) {
        if (clientRepository.findById(id).isEmpty()) {
            throw new NoElementsException("No client with id = " + id);
        }
        bankAccountRepository.deleteAllByClient_Id(id);
        clientRepository.deleteById(id);
    }

    @Override
    public ClientDTO getClientByBankAccountId(long id) {
        Optional<BankAccount> bankAccount = bankAccountRepository.findById(id);
        if (bankAccount.isEmpty()) {
            throw new NoElementsException("No bank account by client with id = " + id);
        }
        return ClientConverter.toModel(bankAccount.get().getClient());
    }
}
