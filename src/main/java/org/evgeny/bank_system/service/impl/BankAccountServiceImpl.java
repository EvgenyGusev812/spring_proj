package org.evgeny.bank_system.service.impl;

import org.evgeny.bank_system.converters.BankAccountConverter;
import org.evgeny.bank_system.dto.BankAccountDTO;
import org.evgeny.bank_system.repository.BankAccountRepository;
import org.evgeny.bank_system.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BankAccountServiceImpl implements BankAccountService {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Override
    public List<BankAccountDTO> getAllBankAccountsByClientId(long id) {
        List<BankAccountDTO> list = bankAccountRepository.findAllByClient_Id(id).stream()
                .map(BankAccountConverter::toModel).collect(Collectors.toList());
        return list;
    }

}
