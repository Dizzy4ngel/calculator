package org.example.exceptions;

public class InvalidCalculatorInputException extends RuntimeException{
    public InvalidCalculatorInputException(){
        super("Invalid parameter(s) was(/were) given. Exiting calculator program.");
    }
}
