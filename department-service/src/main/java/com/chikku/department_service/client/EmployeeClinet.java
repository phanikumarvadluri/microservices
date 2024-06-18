package com.chikku.department_service.client;


import com.chikku.department_service.model.Department;
import com.chikku.department_service.model.Employee;
import com.chikku.department_service.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;


@HttpExchange
public interface EmployeeClinet {
    @GetExchange("/employee/department/{departmentid}")
    public List<Employee> findBydepartmentId(@PathVariable Long departmentid);
}


