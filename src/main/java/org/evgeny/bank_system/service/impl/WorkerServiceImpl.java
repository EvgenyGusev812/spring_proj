package org.evgeny.bank_system.service.impl;

import org.evgeny.bank_system.converters.WorkerConverter;
import org.evgeny.bank_system.entity.Bank;
import org.evgeny.bank_system.entity.Worker;
import org.evgeny.bank_system.dto.WorkerDTO;
import org.evgeny.bank_system.exception_handling.NoElementsException;
import org.evgeny.bank_system.repository.BankRepository;
import org.evgeny.bank_system.repository.WorkerRepository;
import org.evgeny.bank_system.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WorkerServiceImpl implements WorkerService {

    @Autowired
    private WorkerRepository workerRepository;

    @Autowired
    private BankRepository bankRepository;

    @Override
    public WorkerDTO getWorker(Long id) {
        Optional<Worker> worker = workerRepository.findById(id);
        if (worker.isEmpty()) {
            throw new NoElementsException("No worker with id = " + id);
        }
        return WorkerConverter.toModel(workerRepository.getById(id));
    }

    @Override
    public void addWorker(WorkerDTO workerDTO) {
        Worker worker = WorkerConverter.toWorker(workerDTO);
        Bank bankWorker = bankRepository.findByName(workerDTO.getBankName());
        if (bankWorker != null) {
            worker.setBank(bankRepository.findByName(workerDTO.getBankName()));
        }
        else {
            Bank bank = new Bank();
            bank.setName(workerDTO.getBankName());
            worker.setBank(bankRepository.save(bank));
        }
        workerRepository.saveAndFlush(worker);
    }

    @Override
    public List<WorkerDTO> getWorkersByBank(String bankName) {
        Bank bank = bankRepository.findByName(bankName);
        if (bank == null) {
            throw new NoElementsException("No bank with name = " + bankName);
        }
        return workerRepository.findAllByBank(bank).stream().map(WorkerConverter::toModel).collect(Collectors.toList());
    }

    @Override
    public void deleteWorker(long id) {
        if (workerRepository.findById(id).isEmpty()) {
            throw new NoElementsException("No worker with id = " + id);
        }
        workerRepository.deleteById(id);
    }

    @Override
    public List<WorkerDTO> getAll() {
        return workerRepository.findAll().stream().map(WorkerConverter::toModel).collect(Collectors.toList());
    }
}
