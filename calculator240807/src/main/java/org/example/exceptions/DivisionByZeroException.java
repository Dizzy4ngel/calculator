package org.example.exceptions;

public class DivisionByZeroException extends RuntimeException {
    public DivisionByZeroException(){
        super("Division by zero is not allowed. Exiting calculator program.");
    }
}
