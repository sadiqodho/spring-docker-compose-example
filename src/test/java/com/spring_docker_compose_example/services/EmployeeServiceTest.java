package com.spring_docker_compose_example.services;

import com.spring_docker_compose_example.entities.Employee;
import com.spring_docker_compose_example.enums.State;
import com.spring_docker_compose_example.generators.EmployeeDataGenerator;
import com.spring_docker_compose_example.repositories.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;

    @MockBean
    private EmployeeRepository employeeRepository;

    private Employee employee;

    @BeforeEach
    public void before(){
        employee = new EmployeeDataGenerator().generate();
    }

    @Test
    public void addEmployeeTest(){
        when(employeeRepository.save(any())).thenReturn(employee);
        ResponseEntity<Employee> result = employeeService.addEmployee(employee);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals("Abc", result.getBody().getName());
    }

    @Test
    public void changeStateTest(){
        when(employeeRepository.findById(anyLong())).thenReturn(Optional.of(employee));
        when(employeeRepository.save(any())).thenReturn(employee);
        ResponseEntity<Employee> result = employeeService.changeState(1L);
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    public void changeState_nullPointerExceptionTest(){
        when(employeeRepository.findById(anyLong())).thenReturn(null);
        assertThrows(NullPointerException.class, ()-> employeeService.changeState(1L));
    }

    @Test
    public void changeState_responseStatusExceptionTest(){
        Employee employeeWithStatus = new EmployeeDataGenerator().generateWithStatus(State.ACTIVE);
        when(employeeRepository.findById(anyLong())).thenReturn(Optional.of(employeeWithStatus));
        assertThrows(ResponseStatusException.class, ()-> employeeService.changeState(1L));
    }

    @Test
    public void getEmployeeByIdTest(){
        when(employeeRepository.findById(anyLong())).thenReturn(Optional.of(employee));
        ResponseEntity<Employee> result = employeeService.getEmployeeById(1L);
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    public void getEmployeeById_nullPointerExceptionTest(){
        when(employeeRepository.findById(anyLong())).thenReturn(null);
        assertThrows(NullPointerException.class, ()-> employeeService.getEmployeeById(1L));
    }
}
