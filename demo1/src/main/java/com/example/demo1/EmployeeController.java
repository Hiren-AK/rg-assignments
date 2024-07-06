package com.example.demo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path="{employees}")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> allEmployees(){
        return employeeService.getEmployees();
    }

    @PostMapping
    public void registerNewEmployee(@RequestBody Employee employee){
        employeeService.addNewEmployee(employee);
    }

    @DeleteMapping("/{employeeId}")
    public void deleteEmployee(@PathVariable("employeeId") int employeeId){
        employeeService.deleteEmployee(employeeId);
    }

    @PutMapping("/{employeeId}")
    public void updateEmployee(@PathVariable("employeeId") int employeeId,
                               @RequestParam(required = false) String name,
                               @RequestParam(required = false) String department){
        employeeService.updateEmployee(employeeId, name, department);
    }
}
