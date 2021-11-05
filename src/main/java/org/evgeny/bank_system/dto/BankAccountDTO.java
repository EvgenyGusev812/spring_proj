package org.evgeny.bank_system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankAccountDTO {

    private Double currency;
    private Double amount;
    private Double amountOfCredit;
    private String clientFirstName;
    private String clientLastName;
    private String bankName;

}
