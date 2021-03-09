package com.example.apipaging.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer age;
    private Date startdate;
    private Double salary;
    @ManyToOne
    @JoinColumn()
    private Position position;
    @ManyToOne
    @JoinColumn()
    private Office office;
}
