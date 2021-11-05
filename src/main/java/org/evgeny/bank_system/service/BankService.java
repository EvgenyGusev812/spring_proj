package org.evgeny.bank_system.service;

import org.evgeny.bank_system.entity.Bank;

import java.util.List;

public interface BankService {
    Bank addBank(Bank bank);
    List<Bank> getAll();
    Bank getBank(String name);
}
