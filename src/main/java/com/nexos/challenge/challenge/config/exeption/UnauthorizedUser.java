package com.nexos.challenge.challenge.config.exeption;

public class UnauthorizedUser extends RuntimeException{
    public UnauthorizedUser(){}

    public UnauthorizedUser(String message){
        super(message);
    }
}
