package com.nexos.challenge.challenge.config.exeption;

public class NotFoundExeption extends RuntimeException{
    public NotFoundExeption() {
    }

    public NotFoundExeption(String message) {
        super(message);
    }
}
