package com.example.employee.service;

import java.util.List;
import com.example.employee.entity.Employee;

public interface EmployeeService {

    // CREATE
    Employee saveEmployee(Employee employee);

    // READ ALL (only not deleted)
    List<Employee> getAllEmployees();

    // READ BY ID
    Employee getEmployeeById(Long id);

    // UPDATE
    Employee updateEmployee(Long id, Employee employee);

    // SOFT DELETE
    void deleteEmployee(Long id);

    // RESTORE DELETED EMPLOYEE
    Employee restoreEmployee(Long id);

    // GET DELETED EMPLOYEES (optional)
    List<Employee> getDeletedEmployees();
}