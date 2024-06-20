package com.libraryinventory.exceptions;


public class EmptyFieldException extends RuntimeException {
    public EmptyFieldException() {
        super("Empty Field exception! ");
    }
}
