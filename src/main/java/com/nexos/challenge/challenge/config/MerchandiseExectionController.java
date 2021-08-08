package com.nexos.challenge.challenge.config;

import com.nexos.challenge.challenge.config.exeption.BadRequestExeption;
import com.nexos.challenge.challenge.config.exeption.NotFoundExeption;
import com.nexos.challenge.challenge.config.exeption.UnauthorizedUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MerchandiseExectionController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MerchandiseExectionController.class);

    @ExceptionHandler(NotFoundExeption.class)
    public ResponseEntity<?> notFoundException(Exception e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(BadRequestExeption.class)
    public ResponseEntity<?> badRequestException(Exception e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<?> unauthorizedUser(Exception e){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }
}
