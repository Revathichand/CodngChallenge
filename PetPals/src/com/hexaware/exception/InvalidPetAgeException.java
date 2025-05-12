package com.hexaware.exception;

//Throws when a pet is added with an invalid (non-positive) age.
public class InvalidPetAgeException extends Exception {
    public InvalidPetAgeException(String message) {
        super(message);
    }
}
