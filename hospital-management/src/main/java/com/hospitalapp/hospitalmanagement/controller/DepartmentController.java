package com.hospitalapp.hospitalmanagement.controller;

import com.hospitalapp.hospitalmanagement.domain.Department;
import com.hospitalapp.hospitalmanagement.repository.DepartmentRepository;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@CrossOrigin(origins = "http://localhost:3000")
public class DepartmentController {

    private final DepartmentRepository departmentRepo;

    public DepartmentController(DepartmentRepository departmentRepo) {
        this.departmentRepo = departmentRepo;
    }

    @GetMapping("/department")
    public List<Department> getDepartments() {
        return departmentRepo.findAll();
    }

    @PostMapping("/department")
    @Transactional
    public Department saveDepartment(@RequestBody Department department) {

        return departmentRepo.save(department);
    }
}
