package org.evgeny.bank_system.service.impl;

import org.evgeny.bank_system.entity.Bank;
import org.evgeny.bank_system.entity.BankAccount;
import org.evgeny.bank_system.repository.BankRepository;
import org.evgeny.bank_system.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankServiceImpl implements BankService {

    @Autowired
    private BankRepository bankRepository;

    @Override
    public Bank addBank(Bank bank) {
        return bankRepository.saveAndFlush(bank);
    }

    @Override
    public List<Bank> getAll() {
        return bankRepository.findAll();
    }

    @Override
    public Bank getBank(String name) {
        return bankRepository.findByName(name);
    }


}
