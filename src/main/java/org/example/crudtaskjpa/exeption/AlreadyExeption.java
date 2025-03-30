package org.example.crudtaskjpa.exeption;

public class AlreadyExeption extends RuntimeException{
    public AlreadyExeption(String message){
        super(message);
    }
}
