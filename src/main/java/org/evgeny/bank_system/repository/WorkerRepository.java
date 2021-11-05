package org.evgeny.bank_system.repository;

import org.evgeny.bank_system.entity.Bank;
import org.evgeny.bank_system.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
    Worker findByFirstName(String firstName);
    List<Worker> findAllByBank(Bank bank);
}
