package com.chikku.department_service.repository;


import com.chikku.department_service.model.Department;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class DepartmentRepository {

    private List<Department> departments = new ArrayList<>();


    public Department addDepartment(  Department department) {
        departments.add(department);
        return department;
    }

    public Department findById(Long id) {
        Optional<Department> any = departments.stream().filter(department -> department.getId().equals(id)).findAny();
        return any.get();
    }

    public List<Department> findAll() {
        return departments;
    }
}
