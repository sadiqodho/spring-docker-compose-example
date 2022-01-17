package com.spring_docker_compose_example.controllers;

import com.spring_docker_compose_example.entities.Employee;
import com.spring_docker_compose_example.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * @param employee
     * @return ResponseEntity
     */
    @PostMapping
    public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

    /**
     * @param id
     * @return ResponseEntity
     */
    @PutMapping("/{id}")
    public ResponseEntity<Employee> changeState(@PathVariable("id") Long id){
        return employeeService.changeState(id);
    }

    /**
     * @param id
     * @return ResponseEntity
     */
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id){
        return employeeService.getEmployeeById(id);
    }
}
