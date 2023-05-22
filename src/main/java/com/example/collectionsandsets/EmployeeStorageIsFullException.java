package com.example.collectionsandsets;

public class EmployeeStorageIsFullException extends Throwable {
    private String detail;

    public EmployeeStorageIsFullException() {
        detail = "Incorrect password";
    }

    public EmployeeStorageIsFullException(String message) {
        super(message);
        detail = message;
    }

    @Override
    public String toString() {
        return "EmployeeStorageIsFullException: " + detail;
    }
}

