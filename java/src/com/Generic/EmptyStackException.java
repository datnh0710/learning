package com.Generic;

public class EmptyStackException extends RuntimeException{
    public EmptyStackException(){
        this("Stack is empty");
    }
    public EmptyStackException(String messages){
        super(messages);
    }
}
