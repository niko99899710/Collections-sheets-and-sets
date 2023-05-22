package com.example.collectionsandsets;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/employee/add")
    public String gethireEmployee(@RequestParam("firstname") String firstName,
                                  @RequestParam("lastName") String lastName)
            throws EmployeeAlreadyAddedException {
        Employee employee = new Employee(
                firstName,
                lastName
        );
        employeeService.gethireEmployee(employee);
        return "added Employee";
    }

    @GetMapping(path = "/employee/remove")
    public String getEmployee(@RequestParam("firstname") String firstName,
                              @RequestParam("lastName") String lastName)
            throws EmployeeNotFoundException {
        Employee employee = new Employee(
                firstName,
                lastName
        );
        try {
            employeeService.getEmployee(employee);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (EmployeeStorageIsFullException e) {
            throw new RuntimeException(e);
        }
        return "get Employee";
    }

    @GetMapping(path = "/employee/find")
    public String getEmployeeByName(@RequestParam("firstname") String firstName,
                                    @RequestParam("lastName") String lastName)
            throws EmployeeNotFoundException {
        Employee employee = new Employee(
                firstName,
                lastName
        );
        employeeService.getEmployeeByName(firstName, lastName);
        return "get Employee By Name";
    }
}

