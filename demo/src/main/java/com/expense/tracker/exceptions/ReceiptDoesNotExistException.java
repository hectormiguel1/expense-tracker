package com.expense.tracker.exceptions;

public class ReceiptDoesNotExistException extends RuntimeException {
    public ReceiptDoesNotExistException(String message) {
        super(message);
    }


}
