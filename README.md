# Employee Management System (Spring Boot)

A secure Employee Management System built using Spring Boot.

## 🚀 Features

- Add Employee
- Update Employee
- Soft Delete Employee
- View Employee List
- Login Authentication
- Spring Security Integration
- REST APIs
- Layered Architecture

## 🛠️ Technologies Used

- Java 17
- Spring Boot
- Spring Data JPA
- Spring Security
- Hibernate
- MySQL
- Maven

## 📂 Project Structure

com.example.employee
│
├── config
│   ├── SecurityConfig
│   └── WebConfig
│
├── controller
│   ├── AuthController
│   └── EmployeeController
│
├── entity
│   ├── Employee
│   └── User
│
├── repository
│   ├── EmployeeRepository
│   ├── UserRepository
│   ├── EmployeeService
│   └── EmployeeServiceImpl
│
└── EmployeeApplication

## 🔐 Security

- Basic Authentication
- Custom User entity
- Encrypted Password storage

## ▶️ Run the Project

```bash
mvn spring-boot:run
```
http://localhost:8080
```
## 🗄️ Database Configuration

This project uses **PostgreSQL** as the database.

### 🔹 Application Properties

```properties
spring.application.name=employee
server.port=8081

spring.datasource.url=jdbc:postgresql://localhost:5432/employee_db
spring.datasource.username=postgres
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 🔹 Database Setup

1. Install PostgreSQL
2. Create database:

```sql
CREATE DATABASE employee_db;
```

3. Update username and password in `application.properties`

### 🔹 Hibernate Settings

- `ddl-auto=update` → Automatically creates/updates tables
- `show-sql=true` → Displays SQL queries in console


## 📌 Author

Gowtham

Click ⚙️ Settings → Description

Secure Employee Management System built with Spring Boot, JPA, Hibernate, and Spring Security.

