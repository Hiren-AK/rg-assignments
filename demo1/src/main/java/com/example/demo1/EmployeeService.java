package com.example.demo1;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    public void addNewEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public void deleteEmployee(int employeeId) {
        boolean b = employeeRepository.existsById(employeeId);
        if (!b){
            throw new IllegalStateException("employee with id: " + employeeId + " does not exist");
        }
        employeeRepository.deleteById(employeeId);
    }

    @Transactional
    public void updateEmployee(int employeeId, String name, String department) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new IllegalStateException("employee with id: " + employeeId + " does not exist"));

        if (name != null && name.length() > 0 && !Objects.equals(employee.getName(), name)) {
            employee.setName(name);
        }

        if (department != null && department.length() > 0 && !Objects.equals(employee.getDepartment(), department)) {
            employee.setDepartment(department);
        }
        employeeRepository.save(employee);
    }
}