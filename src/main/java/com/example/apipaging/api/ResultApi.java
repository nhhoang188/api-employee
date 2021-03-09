package com.example.apipaging.api;

import com.example.apipaging.dto.EmployeeDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ResultApi {
    private int page;
    private int totalPage;
    private List<EmployeeDto> employeeList = new ArrayList<>();
}
