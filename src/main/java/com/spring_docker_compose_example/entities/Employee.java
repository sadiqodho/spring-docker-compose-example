package com.spring_docker_compose_example.entities;

import com.spring_docker_compose_example.enums.State;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name = "employees")
@NoArgsConstructor
public class Employee{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Name is required")
    @Column
    private String name;

    @Column
    private String email;

    @Column
    private Integer age;

    @Column
    @Enumerated(EnumType.STRING)
    private State state = State.ADDED;

    @OneToOne(cascade = {CascadeType.ALL})
    private Contract contract;
}
