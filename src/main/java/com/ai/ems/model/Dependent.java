package com.ai.ems.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Dependent {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String relationship;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
