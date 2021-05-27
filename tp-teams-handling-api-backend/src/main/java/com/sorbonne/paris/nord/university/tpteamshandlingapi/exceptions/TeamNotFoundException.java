package com.sorbonne.paris.nord.university.tpteamshandlingapi.exceptions;

public class TeamNotFoundException extends RuntimeException {

    public TeamNotFoundException(String message) {
        super(message);
    }
}