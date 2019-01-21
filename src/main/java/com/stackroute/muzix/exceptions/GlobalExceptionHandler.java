package com.stackroute.muzix.exceptions;

import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
//@Log4j
public class GlobalExceptionHandler {

    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason="Track list is empty")
    @ExceptionHandler(TrackListEmptyException.class)
    public void handleTrackListEmptyexception(TrackListEmptyException e){


    }
    @ResponseStatus(value= HttpStatus.CONFLICT, reason = "Track already exists")
    @ExceptionHandler(TrackalreadyExistsException.class)
    public void handleTrackAlreadyExistsException(TrackalreadyExistsException e){

    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Track does not exist")
    @ExceptionHandler(TrackDoesNotExistException.class)
    public void handleTrackDoesNotExistException(TrackDoesNotExistException e)
    {

    }


}
