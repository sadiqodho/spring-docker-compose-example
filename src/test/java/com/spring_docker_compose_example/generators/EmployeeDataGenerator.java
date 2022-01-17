package com.spring_docker_compose_example.generators;

import com.spring_docker_compose_example.entities.Employee;
import com.spring_docker_compose_example.enums.State;

public class EmployeeDataGenerator {
    private Employee employee;

    public Employee generate(){
        return generateWithStatus(State.ADDED);
    }

    public Employee generateWithStatus(State state){
        employee = new Employee();
        employee.setId(1L);
        employee.setName("Abc");
        employee.setState(state);
        employee.setAge(23);
        employee.setEmail("abc@gmail.com");
        return employee;
    }
}
