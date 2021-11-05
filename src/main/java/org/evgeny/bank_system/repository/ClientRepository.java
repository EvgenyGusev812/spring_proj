package org.evgeny.bank_system.repository;

import org.evgeny.bank_system.entity.BankAccount;
import org.evgeny.bank_system.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {
    List<Client> findAllByBankName(String bankName);
}
