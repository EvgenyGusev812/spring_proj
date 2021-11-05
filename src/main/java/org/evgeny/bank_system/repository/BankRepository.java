package org.evgeny.bank_system.repository;

import org.evgeny.bank_system.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BankRepository extends JpaRepository<Bank, Long> {

    Bank findByName(String name);
}
