package com.example.collectionsandsets;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public abstract class EmployeeService implements Service123 {
    List<Employee> workers = new ArrayList<>(List.of(
            new Employee("Piter", "Parker"),
            new Employee("Adrean", "Still")
    ));

        @Override
    public String getEmployee(Integer numberMax) throws EmployeeStorageIsFullException {
        final Employee employee;
         numberMax = 3;
        if (numberMax >= workers.size()) {
            throw new EmployeeStorageIsFullException("Максимальное колличество мест");
        }
        employee = workers.get(numberMax);

        final String Max = "" + employee.getFirstName() + "" + employee.getLastName();
        return Max;
    }

    @Override
    public boolean getEmployeeByName(String firstName, String lastName) throws EmployeeNotFoundException {
        for (Employee employee : this.workers) {
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
                throw new EmployeeNotFoundException("EmployeeNotFoundException");
            }
        }
        return true;
    }

    @Override
    public boolean gethireEmployee(Employee newEmployee) throws EmployeeAlreadyAddedException {
        String lastName = null;
        String firstName = null;
        List<Employee> newEmployees = List.of(new Employee[this.workers.size() + 1]);
        System.arraycopy(this.workers, 0, newEmployees, 0, this.workers.size());
        newEmployees.set(this.workers.size(), newEmployee);
        this.workers = List.of((Employee) newEmployees);
        if (((Employee) newEmployees).getFirstName().equals(firstName) && newEmployee.getLastName().equals(lastName)) {
            throw new EmployeeAlreadyAddedException("EmployeeAlreadyAddedException");
        }
        return true;
    }

    @Override
    public void fireEmployee(String lastName, String firstName) throws EmployeeNotFoundException {
        for (int removedIdx = 0; removedIdx < this.workers.size(); removedIdx++) {
            Employee employee = this.workers.get(removedIdx);
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {

                List<Employee> newEmployees = List.of(new Employee[this.workers.size() - 1]);
                ;
                System.arraycopy(this.workers, 0, newEmployees, 0, removedIdx);
                if (this.workers.size() != removedIdx) {
                    System.arraycopy(this.workers, removedIdx + 1, newEmployees, removedIdx,
                            this.workers.size() - removedIdx - 1);
                }
                this.workers = newEmployees;


                return;
            } else if (employee.getFirstName().equals(firstName) || employee.getLastName().equals(lastName)) {
                throw new EmployeeNotFoundException("EmployeeNotFoundException");
            } else {
                System.out.println("никого не нашли");
            }
        }
    }
}


