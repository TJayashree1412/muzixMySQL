package com.stackroute.muzix.exceptions;

public class TrackListEmptyException extends Exception {
    public String message;

    public TrackListEmptyException() {
    }

    public TrackListEmptyException(String message) {
        this.message = message;
    }
}
