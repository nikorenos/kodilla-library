package com.crud.kodillalibrary.controller;

public class BookNotFoundException extends Exception {
    public BookNotFoundException() {
        super("Wrong book id");
    }
    public BookNotFoundException(final String message) {
        super(message);
    }
}

