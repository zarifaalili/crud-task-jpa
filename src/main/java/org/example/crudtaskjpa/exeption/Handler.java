package org.example.crudtaskjpa.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Handler {

    @ExceptionHandler(AlreadyExeption.class)
    public ResponseEntity<Response> handle(AlreadyExeption exeption){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response(exeption.getMessage(),"insert olunmadi"));
    }
    @ExceptionHandler(NotFoundExeption.class)
    public ResponseEntity<Response> handle2(NotFoundExeption exeption){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response(exeption.getMessage(),"employee tapilmadi"));
    }
}
