package org.evgeny.bank_system.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClientDTO {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String mail;
    private String bankName;
}
