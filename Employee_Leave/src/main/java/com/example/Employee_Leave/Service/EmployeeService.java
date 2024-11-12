package com.example.Employee_Leave.Service;

import com.example.Employee_Leave.Entity.Employee;
import com.example.Employee_Leave.Repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;



    public Employee addStaffMember(Employee employee) {

        return employeeRepository.save(employee);
    }
}
