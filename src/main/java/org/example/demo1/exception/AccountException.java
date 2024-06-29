package org.example.demo1.exception;

public class AccountException extends RuntimeException {
    String message;
    public AccountException(String message){
        super(message);
        this.message=message;
    }
}
