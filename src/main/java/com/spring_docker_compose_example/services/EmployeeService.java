package com.spring_docker_compose_example.services;

import com.spring_docker_compose_example.entities.Employee;
import com.spring_docker_compose_example.enums.State;
import com.spring_docker_compose_example.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public ResponseEntity<Employee> addEmployee(Employee employee){
        return new ResponseEntity<>(employeeRepository.save(employee), HttpStatus.OK);
    }

    public ResponseEntity<Employee> changeState(Long id){
        Employee employee = employeeRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Employee not found exception with following Id: %d", id)));

        if(State.ACTIVE.equals(employee.getState())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    String.format("Employee is already active with following Id: %d", id));
        }

        employee.setState(employee.getState().nextState());
        employee = employeeRepository.save(employee);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }


    public ResponseEntity<Employee> getEmployeeById(Long id){
        Employee employee = employeeRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Employee not found exception with following Id: %d", id)));
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

}
