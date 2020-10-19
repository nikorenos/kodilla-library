package com.crud.kodillalibrary.controller;


public class TitleNotFoundException extends Exception {
    public TitleNotFoundException() {
        super("Wrong title id");
    }
    public TitleNotFoundException(final String message) {
        super(message);
    }
}
