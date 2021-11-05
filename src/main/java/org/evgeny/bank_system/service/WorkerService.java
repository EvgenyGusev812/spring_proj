package org.evgeny.bank_system.service;

import org.evgeny.bank_system.entity.Worker;
import org.evgeny.bank_system.dto.WorkerDTO;

import java.util.List;

public interface WorkerService {

    void addWorker(WorkerDTO workerDTO);
    void deleteWorker(long id);
    List<WorkerDTO> getWorkersByBank(String bankName);
    WorkerDTO getWorker(Long id);
    List<WorkerDTO> getAll();
}
