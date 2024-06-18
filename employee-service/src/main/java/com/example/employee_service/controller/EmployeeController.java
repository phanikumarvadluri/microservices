package com.example.employee_service.controller;


import com.example.employee_service.model.Employee;
import com.example.employee_service.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@Slf4j
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;


    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        log.info("employee add" + employee);
        return employeeRepository.addDepartment(employee);
    }


    @GetMapping
    public List<Employee> findAll() {
        log.info("findAll");
        return employeeRepository.findAll();

    }
    @GetMapping("/{id}")
    public Employee findById(@PathVariable Long id) {
        log.info("employee findById" + id);
        return employeeRepository.findById(id);
    }

    @GetMapping("/department/{departmentid}")
    public List<Employee> findBydepartmentId(@PathVariable Long departmentid) {
        log.info("employee departmentid" + departmentid);
        return employeeRepository.findByDepartmentId(departmentid);
    }
}
