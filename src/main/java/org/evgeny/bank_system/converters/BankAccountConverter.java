package org.evgeny.bank_system.converters;

import org.evgeny.bank_system.dto.BankAccountDTO;
import org.evgeny.bank_system.entity.BankAccount;

public class BankAccountConverter {

    public static BankAccountDTO toModel(BankAccount bankAccount) {
        BankAccountDTO bankAccountDTO = new BankAccountDTO();
        bankAccountDTO.setCurrency(bankAccount.getCurrency());
        bankAccountDTO.setAmount(bankAccount.getAmount());
        bankAccountDTO.setAmountOfCredit(bankAccount.getAmountOfCredit());
        bankAccountDTO.setClientFirstName(bankAccount.getClient().getFirstName());
        bankAccountDTO.setClientLastName(bankAccount.getClient().getLastName());
        bankAccountDTO.setBankName(bankAccount.getClient().getBank().getName());
        return bankAccountDTO;
    }

    public static BankAccount toBankAccount(BankAccountDTO bankAccountDTO) {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setAmount(bankAccountDTO.getAmount());
        bankAccount.setCurrency(bankAccountDTO.getCurrency());
        bankAccount.setAmountOfCredit(bankAccountDTO.getAmountOfCredit());
        return bankAccount;
    }
}
