package com.example.demo.controller;

import com.example.demo.entity.DepartmentEntity;
import com.example.demo.model.request.DepartmentRequest;
import com.example.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DepartmentController {

    @Autowired
    public DepartmentService departmentService;

    @GetMapping(value = "/department/{id}")
    public DepartmentEntity getByID(@PathVariable("id") int id){
        return departmentService.findById(id);
//        return null;
    }

    @PostMapping(value = "/department/add")
    public DepartmentEntity addDepartment(@RequestBody DepartmentRequest department){
//        return department;
        return departmentService.addDepartment(department);
    }
}
