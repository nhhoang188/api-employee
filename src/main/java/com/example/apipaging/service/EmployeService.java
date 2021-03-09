package com.example.apipaging.service;

import com.example.apipaging.dto.EmployeeDto;
import com.example.apipaging.model.Employee;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeService {
    EmployeeDto save(EmployeeDto employee);
    void deleteEmployeeById(Long id);
    List<EmployeeDto> findAll(Pageable pageable);
    EmployeeDto findById(Long id);
    int totalItem();
}
