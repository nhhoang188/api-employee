package com.example.apipaging.dto;

import lombok.Data;

import java.util.Date;

@Data
public class EmployeeDto {
    private Long id;
    private String name;
    private Integer age;
    private Date startdate;
    private Double salary;
    private String position;
    private String office;
}
