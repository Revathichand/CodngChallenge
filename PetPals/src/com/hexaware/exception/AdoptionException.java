package com.hexaware.exception;

//Custom exception for errors during pet adoption process.
public class AdoptionException extends Exception {
    public AdoptionException(String message) {
        super(message);
    }
}
