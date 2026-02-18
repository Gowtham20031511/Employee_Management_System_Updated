package com.example.employee.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.employee.entity.Employee;
import com.example.employee.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin("*")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    // ================= SAVE =================
    @PostMapping
    public ResponseEntity<?> saveEmployee(@RequestBody Employee employee) {
        try {
            return ResponseEntity.ok(service.saveEmployee(employee));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // ================= GET ALL ACTIVE =================
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(service.getAllEmployees());
    }

    // ================= GET BY ID =================
    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployee(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(service.getEmployeeById(id));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // ================= UPDATE =================
    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable Long id,
                                            @RequestBody Employee employee) {
        try {
            return ResponseEntity.ok(service.updateEmployee(id, employee));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // ================= SOFT DELETE =================
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        service.deleteEmployee(id);
        return ResponseEntity.ok("Employee soft deleted");
    }

    // ================= GET DELETED EMPLOYEES =================
    @GetMapping("/deleted")
    public ResponseEntity<List<Employee>> getDeletedEmployees() {
        return ResponseEntity.ok(service.getDeletedEmployees());
    }

    // ================= RESTORE EMPLOYEE =================
    @PutMapping("/restore/{id}")
    public ResponseEntity<?> restoreEmployee(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(service.restoreEmployee(id));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
