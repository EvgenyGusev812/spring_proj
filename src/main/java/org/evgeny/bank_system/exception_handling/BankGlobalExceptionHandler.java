package org.evgeny.bank_system.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BankGlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<BankIncorrectData> handleException(NoElementsException e) {
        BankIncorrectData data = new BankIncorrectData();
        data.setInfo(e.getMessage());
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }
}
