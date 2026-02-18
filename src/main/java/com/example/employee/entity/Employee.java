package com.example.employee.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Getter
@Setter
@Entity
@Table(
        name = "employees",
        indexes = @Index(name = "idx_email_unique", columnList = "email", unique = true)
)
@JsonPropertyOrder({ "id", "name", "email", "department", "salary", "deleted" })
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // This is your SNO, never changes

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email; // Unique key

    @Column(nullable = false)
    private String department;

    @Column(nullable = false)
    private double salary;

    // Soft Delete Flag
    private boolean deleted = false;
}
