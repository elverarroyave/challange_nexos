package com.nexos.challenge.challenge.config.exeption;

public class BadRequestExeption extends RuntimeException{
    public BadRequestExeption() {
    }

    public BadRequestExeption(String message) {
        super(message);
    }
}
