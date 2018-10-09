package com.stackroute.movieservice.exceptions;

public class MovieNotFoundException extends Exception{
    String message;

    public MovieNotFoundException() {
    }

    public MovieNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
