package org.evgeny.bank_system.controller;

import org.evgeny.bank_system.entity.Bank;
import org.evgeny.bank_system.exception_handling.NoElementsException;
import org.evgeny.bank_system.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/banks")
public class BankController {

    @Autowired
    private BankService bankService;

    @GetMapping("/")
    public List<Bank> getAllBanks() {
        List<Bank> banks = bankService.getAll();
        if (banks.isEmpty()) {
            throw new NoElementsException("No banks in system");
        }
        return banks;
    }

    @PostMapping("/add")
    public void addBank(@RequestBody Bank bank) {
        bankService.addBank(bank);
    }

}
