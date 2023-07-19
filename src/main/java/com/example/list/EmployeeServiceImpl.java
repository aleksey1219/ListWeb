package com.example.list;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static final int MAX_EMPLOYEES = 100;
    private List<Employee> employees;

    public EmployeeServiceImpl() {
        this.employees = new ArrayList<>();

    }
@Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee newEmployee = new Employee(firstName, lastName);
    if (employees.size() >= MAX_EMPLOYEES) {

             throw new EmployeeStorageIsFullException("Достигнуто максимальное количество сотрудников");
    }
        if (employees.contains(newEmployee)) {
            throw new EmployeeAlreadyAddedException("Сотрудник уже существует");
        }
        employees.add(newEmployee);
        return newEmployee;
    }



    @Override
    public void removeEmployee(String firstName, String lastName) {
        Employee employeeToRemove = findEmployee(firstName, lastName);
        employees.remove(employeeToRemove);
    }
    @Override
    public Employee findEmployee(String firstName, String lastName) {
        for (Employee employee : employees) {
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
                return employee;
            }
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }
    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }
}
