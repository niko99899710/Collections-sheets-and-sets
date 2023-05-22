package com.example.collectionsandsets;

public class EmployeeAlreadyAddedException extends Throwable {
    private String detail;

    public EmployeeAlreadyAddedException() {
        detail = "Incorrect password";
    }

    public EmployeeAlreadyAddedException(String message) {
        super(message);
        detail = message;
    }

    @Override
    public String toString() {
        return "EmployeeAlreadyAddedException: " + detail;
    }
}
