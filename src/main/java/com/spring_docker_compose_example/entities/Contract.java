package com.spring_docker_compose_example.entities;

import com.spring_docker_compose_example.enums.ContractType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "contract")
@NoArgsConstructor
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private ContractType contractType;

    @Column
    private Double salary;
}
