package com.chikku.department_service.controller;


import com.chikku.department_service.client.EmployeeClinet;
import com.chikku.department_service.model.Department;
import com.chikku.department_service.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

@RestController
@RequestMapping("/department")
@Slf4j
public class DepartementController {

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    EmployeeClinet employeeClinet;


    @PostMapping
    public Department addDepartment(@RequestBody Department department) {

        log.info("addDepartment" + department);
        log.info("addDepartment" + department.getId());
        log.info("addDepartment" + department.getName());
        return departmentRepository.addDepartment(department);

    }

    @GetMapping
    public List<Department> findAll() {
        log.info("findAll");
        return departmentRepository.findAll();

    }

    @GetMapping("/{id}")
    public Department findById(@PathVariable Long id) {
        log.info("Service method  findById called using @Slf4j" + id);
        return departmentRepository.findById(id);

    }

    @GetMapping("/with-employees")
    public List<Department> filterall() {
        List<Department> all = departmentRepository.findAll();
        all.forEach(department -> department.setEmployees((employeeClinet.findBydepartmentId(department.getId()))));
        return all;
    }

}
