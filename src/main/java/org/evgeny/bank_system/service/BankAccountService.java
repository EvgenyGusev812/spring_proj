package org.evgeny.bank_system.service;


import org.evgeny.bank_system.dto.BankAccountDTO;
import org.evgeny.bank_system.entity.BankAccount;
import org.evgeny.bank_system.entity.Client;

import java.util.List;

public interface BankAccountService {

    List<BankAccountDTO> getAllBankAccountsByClientId(long id);
}
