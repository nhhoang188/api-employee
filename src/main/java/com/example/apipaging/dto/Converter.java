package com.example.apipaging.dto;

import com.example.apipaging.model.Employee;
import com.example.apipaging.model.Office;
import com.example.apipaging.model.Position;
import com.example.apipaging.repository.EmployeeRepo;
import com.example.apipaging.repository.OfficeRepo;
import com.example.apipaging.repository.PositionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Converter {
    @Autowired
    EmployeeRepo employeeRepo;
    @Autowired
    PositionRepo positionRepo;
    @Autowired
    OfficeRepo officeRepo;
//    @Autowired
//    public ModelMapper modelMapper() {
//        return new ModelMapper();
//    }
    public Employee toEmployee(EmployeeDto employeeDto){
        Position position = positionRepo.findByName(employeeDto.getPosition());
        Office office = officeRepo.findByName(employeeDto.getOffice());
        Employee employee = new Employee();
        employee.setId(employeeDto.getId());
        employee.setPosition(position);
        employee.setOffice(office);
        employee.setAge(employeeDto.getAge());
        employee.setName(employeeDto.getName());
        employee.setSalary(employeeDto.getSalary());
        employee.setStartdate(employeeDto.getStartdate());
        return employee;
    }
    public EmployeeDto employeeDto(Employee employee){
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setOffice(employee.getOffice().getName());
        employeeDto.setPosition(employee.getPosition().getName());
        employeeDto.setAge(employee.getAge());
        employeeDto.setName(employee.getName());
        employeeDto.setSalary(employee.getSalary());
        employeeDto.setStartdate(employee.getStartdate());
        return employeeDto;
    }
}
