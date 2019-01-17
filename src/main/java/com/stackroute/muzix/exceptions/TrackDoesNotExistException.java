package com.stackroute.muzix.exceptions;

public class TrackDoesNotExistException extends Exception{
    public String message;

    public TrackDoesNotExistException(String message) {
        super(message);
        this.message = message;
    }

    public TrackDoesNotExistException() {
    }
}
