package com.example.list;

import java.util.List;

public interface EmployeeService {
    void removeEmployee(String firstName, String lastName);
     Employee addEmployee(String firstName, String lastName);
    Employee findEmployee(String firstName, String lastName);

    List<Employee> getAllEmployees();
}

