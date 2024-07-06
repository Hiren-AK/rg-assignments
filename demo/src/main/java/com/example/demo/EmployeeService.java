package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee createEmployee(Employee employee) {
        employeeRepository.save(employee);
        return employee;
    }

    @Transactional
    public void updateEmployee(int id, Optional<String> name, Optional<String> department) {
        // Find the existing employee
        Employee employee = employeeRepository.findById(id);
        if (employee == null) {
            throw new RuntimeException("Employee not found with id: " + id);
        }

        // Update fields if present
        name.ifPresent(employee::setName);
        department.ifPresent(employee::setDepartment);

        // Update employee in the repository
        employeeRepository.update(employee);
    }

    public void deleteEmployee(int id) {
        employeeRepository.delete(id);
    }

    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}

