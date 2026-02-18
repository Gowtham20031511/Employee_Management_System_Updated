package com.example.employee.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.employee.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Get only active employees (not deleted)
    List<Employee> findByDeletedFalse();

    // Get deleted employees (for restore)
    List<Employee> findByDeletedTrue();

    Optional<Employee> findByEmailAndDeletedFalse(String email);
}
