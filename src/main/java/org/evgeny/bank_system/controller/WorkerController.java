package org.evgeny.bank_system.controller;

import org.evgeny.bank_system.dto.WorkerDTO;
import org.evgeny.bank_system.exception_handling.NoElementsException;
import org.evgeny.bank_system.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workers")
public class WorkerController {

    @Autowired
    private WorkerService workerService;

    @GetMapping("/")
    public List<WorkerDTO> getAllWorkers() {
        List<WorkerDTO> workers = workerService.getAll();
        if (workers.isEmpty()) {
            throw new NoElementsException("No workers in system");
        }
        return workers;
    }

    @GetMapping("/id/{id}")
    public WorkerDTO getWorker(@PathVariable long id) {
        WorkerDTO worker = workerService.getWorker(id);
        if (worker == null) {
            throw new NoElementsException("No worker with id = " + id);
        }
        return worker;
    }

    @GetMapping("/{bankName}")
    public List<WorkerDTO> getWorkersByBankName(@PathVariable String bankName) {
        List<WorkerDTO> workers = workerService.getWorkersByBank(bankName);
        if (workers.isEmpty()) {
            throw new NoElementsException("No workers in " + bankName);
        }
        return workers;
    }

    @PostMapping("/add")
    public void addWorker(@RequestBody WorkerDTO workerDTO) {
        workerService.addWorker(workerDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteWorker(@PathVariable long id) {
        workerService.deleteWorker(id);
    }


}
