package com.example.list;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private static final int MAX_EMPLOYEES = 100;
    private List<Employee> employees;

    public EmployeeService() {
        this.employees = new ArrayList<>();

    }

    public void addEmployee(String firstName, String lastName) {
        if (employees.size() >= MAX_EMPLOYEES) {
            throw new EmployeeStorageIsFullException("Достигнуто максимальное количество сотрудников");
        }

        Employee newEmployee = new Employee(firstName, lastName);

        for (Employee employee : employees) {
            if (employee.equals(newEmployee)) {
                throw new EmployeeAlreadyAddedException("Сотрудник уже существует");
            }
        }

        employees.add(newEmployee);
    }

    public void removeEmployee(String firstName, String lastName) {
        Employee employeeToRemove = findEmployee(firstName, lastName);
        employees.remove(employeeToRemove);
    }

    public Employee findEmployee(String firstName, String lastName) {
        for (Employee employee : employees) {
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
                return employee;
            }
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }
}
