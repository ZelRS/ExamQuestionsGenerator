package ru.skypro.examquestionsgenerator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AmountException extends RuntimeException {
    public AmountException() {
    }

    public AmountException(String message) {
        super(message);
    }
}