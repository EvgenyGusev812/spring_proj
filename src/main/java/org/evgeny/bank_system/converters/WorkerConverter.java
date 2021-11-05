package org.evgeny.bank_system.converters;

import org.evgeny.bank_system.entity.Worker;
import org.evgeny.bank_system.dto.WorkerDTO;

public class WorkerConverter {

    public static WorkerDTO toModel(Worker worker) {
        WorkerDTO workerDTO = new WorkerDTO();
        workerDTO.setWorkerStatus(worker.getStatus());
        workerDTO.setPhoneNumber(worker.getPhoneNumber());
        workerDTO.setFirstName(worker.getFirstName());
        workerDTO.setLastName(worker.getLastName());
        workerDTO.setBankName(worker.getBank().getName());
        return workerDTO;
    }

    public static Worker toWorker(WorkerDTO workerDTO) {
        Worker worker = new Worker();
        worker.setFirstName(workerDTO.getFirstName());
        worker.setLastName(workerDTO.getLastName());
        worker.setStatus(workerDTO.getWorkerStatus());
        worker.setPhoneNumber(workerDTO.getPhoneNumber());
        return worker;
    }
}
