package com.example.employee.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.employee.entity.Employee;

@Service
public class EmployeeServiceImpl implements com.example.employee.service.EmployeeService {

    private final EmployeeRepository repo;

    public EmployeeServiceImpl(EmployeeRepository repo) {
        this.repo = repo;
    }

    // ================= CREATE =================
    @Override
    public Employee saveEmployee(Employee employee) {

        // Check duplicate email (only active employees)
        Optional<Employee> existingEmail =
                repo.findByEmailAndDeletedFalse(employee.getEmail());

        if (existingEmail.isPresent()) {
            throw new RuntimeException("Email already exists!");
        }

        employee.setDeleted(false);
        return repo.save(employee);
    }

    // ================= READ ALL =================
    @Override
    public List<Employee> getAllEmployees() {
        return repo.findByDeletedFalse();
    }

    // ================= READ BY ID =================
    @Override
    public Employee getEmployeeById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    // ================= UPDATE =================
    @Override
    public Employee updateEmployee(Long id, Employee employee) {

        Employee existing = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        // Check email uniqueness (allow same employee to keep same email)
        Optional<Employee> emailCheck =
                repo.findByEmailAndDeletedFalse(employee.getEmail());

        if (emailCheck.isPresent() &&
                !emailCheck.get().getId().equals(id)) {
            throw new RuntimeException("Email already exists!");
        }

        existing.setName(employee.getName());
        existing.setEmail(employee.getEmail());
        existing.setDepartment(employee.getDepartment());
        existing.setSalary(employee.getSalary());

        return repo.save(existing);
    }

    // ================= SOFT DELETE =================
    @Override
    public void deleteEmployee(Long id) {

        Employee emp = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        emp.setDeleted(true);
        repo.save(emp);
    }

    // ================= RESTORE =================
    @Override
    public Employee restoreEmployee(Long id) {

        Employee emp = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        // Check email conflict before restoring
        Optional<Employee> emailCheck =
                repo.findByEmailAndDeletedFalse(emp.getEmail());

        if (emailCheck.isPresent()) {
            throw new RuntimeException("Cannot restore. Email already used!");
        }

        emp.setDeleted(false);
        return repo.save(emp);
    }

    // ================= GET DELETED =================
    @Override
    public List<Employee> getDeletedEmployees() {
        return repo.findByDeletedTrue();
    }
}
