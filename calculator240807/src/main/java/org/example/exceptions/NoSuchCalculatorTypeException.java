package org.example.exceptions;

public class NoSuchCalculatorTypeException extends RuntimeException{
    public NoSuchCalculatorTypeException(){
        super("There is no such calculator type. Exiting calculator program.");
    }
}
