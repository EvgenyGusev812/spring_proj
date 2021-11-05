package org.evgeny.bank_system.controller;

import org.evgeny.bank_system.dto.ClientDTO;
import org.evgeny.bank_system.entity.BankAccount;
import org.evgeny.bank_system.entity.Client;
import org.evgeny.bank_system.exception_handling.NoElementsException;
import org.evgeny.bank_system.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/accounts/{id}")
    public ClientDTO getAllInfoAboutClient(@PathVariable long id) {
        return clientService.getAllInfoAboutClient(id);
    }


    @GetMapping("/{bankName}")
    public List<ClientDTO> getAllClientsByBankName(@PathVariable String bankName) {
        List<ClientDTO> clients = clientService.getAllClientsByBankName(bankName);
        if (clients.isEmpty()) {
            throw new NoElementsException("No clients in " + bankName);
        }
        return clients;
    }

    @PostMapping("/add")
    public void addClient(@RequestBody ClientDTO clientDTO) {
        clientService.addClient(clientDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteClient(@PathVariable long id) {
        clientService.deleteClient(id);
    }

    @GetMapping("/account/{id}")
    public ClientDTO getClientByBankAccountId(@PathVariable  long id) {
        return clientService.getClientByBankAccountId(id);
    }

}
