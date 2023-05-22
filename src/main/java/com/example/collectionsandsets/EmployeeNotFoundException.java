package com.example.collectionsandsets;

public class EmployeeNotFoundException extends Throwable {
    private String detail;

    public EmployeeNotFoundException() {
        detail = "Incorrect password";
    }

    public EmployeeNotFoundException(String message) {
        super(message);
        detail = message;
    }

    @Override
    public String toString() {
        return "EmployeeNotFoundException: " + detail;
    }
}
