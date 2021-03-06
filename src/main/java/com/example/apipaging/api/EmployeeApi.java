package com.example.apipaging.api;

import com.example.apipaging.dto.EmployeeDto;
import com.example.apipaging.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin("*")
@RestController
public class EmployeeApi {
    @Autowired
    EmployeService employeService;

    @GetMapping("/employee")
    public ResultApi showEmployee(@RequestParam("page") Optional<String> page, @RequestParam("limit") Optional<String> limit,@RequestParam("sort") Optional<String> sort ) {
        ResultApi result = new ResultApi();
        Pageable pageable;
        if (page.isPresent() && limit.isPresent()) {
            result.setPage(Integer.parseInt(page.get()));
            pageable = sort.map(s -> PageRequest.of(Integer.parseInt(page.get()) - 1, Integer.parseInt(limit.get()), Sort.by(s))).orElseGet(() -> PageRequest.of(Integer.parseInt(page.get()) - 1, Integer.parseInt(limit.get()), Sort.by("id")));
            result.setEmployeeList(employeService.findAll(pageable));
            result.setTotalPage((int) Math.ceil(employeService.totalItem() / Integer.parseInt(limit.get())) + 1);
        } else {
            result.setPage(1);
            pageable = PageRequest.of(0, 5, Sort.by("id"));
            result.setTotalPage((int) Math.ceil(employeService.totalItem() /5));
            result.setEmployeeList(employeService.findAll(pageable));
        }

        return result;
    }

    @PostMapping("/create")
    public EmployeeDto createEmployee(@RequestBody EmployeeDto employeeDto) {
        return employeService.save(employeeDto);
    }

    @DeleteMapping("/employee/{id}")
    public void deleteEmploye(@PathVariable Long id) {
        employeService.deleteEmployeeById(id);
    }
    @GetMapping("/employee/{id}")
    public EmployeeDto showEmploye(@PathVariable Long id){
        return employeService.findById(id);
    }
    @PutMapping("/employee/edit/{id}")
    public EmployeeDto editEmployee(@PathVariable Long id, @RequestBody EmployeeDto employeeDto) {
        employeeDto.setId(id);
        return employeService.save(employeeDto);
    }
}
