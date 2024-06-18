package com.example.employee_service.repository;


import com.example.employee_service.model.Employee;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employee")
public class EmployeeRepository {

    private List<Employee> employees = new ArrayList<>();


    public Employee addDepartment(Employee employee) {
        employees.add(employee);
        return employee;
    }

    public Employee findById(Long id) {
        Optional<Employee> any = employees.stream().filter(department -> department.id().equals(id)).findAny();
        return any.get();
    }

    public List<Employee> findAll() {
        return employees;
    }

    public List<Employee>  findByDepartmentId(Long departmentId) {
        List<Employee> collect = employees.stream().filter(department -> department.departmentId().equals(departmentId)).collect(Collectors.toList());
        return collect;
    }
}
