package org.evgeny.bank_system.controller;

import org.evgeny.bank_system.dto.BankAccountDTO;
import org.evgeny.bank_system.exception_handling.NoElementsException;
import org.evgeny.bank_system.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bankAcc")
public class BankAccountController {

    @Autowired
    private BankAccountService bankAccountService;

    @GetMapping("/bankAccounts/{id}")
    public List<BankAccountDTO> findAllByClientId(@PathVariable long id) {
        List<BankAccountDTO> accounts = bankAccountService.getAllBankAccountsByClientId(id);
        if (accounts.isEmpty()) {
            throw new NoElementsException("There is no bank accounts for client with id = " + id);
        }
        return accounts;
    }
}
