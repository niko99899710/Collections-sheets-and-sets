package com.example.collectionsandsets;

public interface Service123 {
    String getEmployee(Employee employee) throws InterruptedException,  EmployeeStorageIsFullException;

    String getEmployee(Integer numberMax) throws EmployeeStorageIsFullException;

    boolean getEmployeeByName(String lastName, String firstName) throws EmployeeNotFoundException;

    void hireEmployee(Employee newEmployee) throws EmployeeAlreadyAddedException;

    boolean gethireEmployee(Employee newEmployee) throws EmployeeAlreadyAddedException;

    void fireEmployee(String lastName, String firstName) throws EmployeeNotFoundException;
}
