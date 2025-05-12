package com.hexaware.exception;

//Thrown when a donation amount is less than the minimum allowed (e.g.,$10).
public class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}
