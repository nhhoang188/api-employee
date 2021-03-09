package com.example.apipaging.service;

import com.example.apipaging.dto.Converter;
import com.example.apipaging.dto.EmployeeDto;
import com.example.apipaging.model.Employee;
import com.example.apipaging.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class EmployeServiceImpl implements EmployeService{
    @Autowired
    EmployeeRepo employeeRepo;
    @Autowired
    Converter converter;
    @Override
    public EmployeeDto save(EmployeeDto employeeDto) {
        Employee employee = converter.toEmployee(employeeDto);
        employeeRepo.save(employee);
        return employeeDto;
    }

    @Override
    public void deleteEmployeeById(Long id) {
        employeeRepo.deleteById(id);
    }

    @Override
    public List<EmployeeDto> findAll(Pageable pageable) {
        List<EmployeeDto> result = new ArrayList<>();
        List<Employee> employees = employeeRepo.findAll(pageable).getContent();
        for (Employee e:employees) {
            EmployeeDto employeeDto = converter.employeeDto(e);
            result.add(employeeDto);
        }
        return result;
    }

    @Override
    public EmployeeDto findById(Long id) {
        Employee employee = employeeRepo.findEmployeeById(id);
        return converter.employeeDto(employee);
    }

    @Override
    public int totalItem() {
        return (int) employeeRepo.count();
    }
}
