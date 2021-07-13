package com.expense.tracker.exceptions;

public class UserDoesNotExistException extends RuntimeException 
{
    public UserDoesNotExistException(String message) {
        super(message);
    }
}
    

