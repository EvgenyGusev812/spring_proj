package org.evgeny.bank_system.repository;

import org.evgeny.bank_system.entity.BankAccount;
import org.evgeny.bank_system.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {

    void deleteAllByClient_Id(long id);
    List<BankAccount> findAllByClient_Id(long id);

}
