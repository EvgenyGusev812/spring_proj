package org.evgeny.bank_system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.evgeny.bank_system.entity.enums.WorkerStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkerDTO {

    private String firstName;
    private String lastName;
    private WorkerStatus workerStatus;
    private String phoneNumber;
    private String bankName;
}
