package com.example.Employee_Leave.Repository;

import com.example.Employee_Leave.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
