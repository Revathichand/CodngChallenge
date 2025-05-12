package com.hexaware.exception;

//Throws when a pet has null or missing property like name or breed
public class NullPetPropertyException extends Exception {
    public NullPetPropertyException(String message) {
        super(message);
    }
}

