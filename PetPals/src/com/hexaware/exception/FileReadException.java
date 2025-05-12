package com.hexaware.exception;

import java.io.IOException;

//Wraps file-related exceptions such as FileNotFound or Read errors.
public class FileReadException extends IOException {
    public FileReadException(String message) {
        super(message);
    }
}
