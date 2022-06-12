package com.example.demo.controller;

import com.example.demo.entity.DepartmentEntity;
import com.example.demo.model.request.DepartmentRequest;
import com.example.demo.model.request.EmployeeRequest;
import com.example.demo.model.response.EmployeeGetAllResponse;
import com.example.demo.repository.dao.EmployeeDao;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeesController {

    @Autowired
    public EmployeeService employeeService;

    @Autowired
    public EmployeeDao employeeDao;

    @GetMapping(value = "/employees_list")
    public List<EmployeeGetAllResponse> getAll(){
        return employeeService.getAll();
    }

    @GetMapping(value = "/employees/{id}")
    public EmployeeGetAllResponse getById(@PathVariable("id") int id){
        return employeeDao.getResponse(id);
    }

    @GetMapping(value = "/user_list")
    public String getUserrAll(){
        return employeeDao.getUser();
    }
    @PostMapping(value = "/employees/add")
    public EmployeeGetAllResponse addEmployees(@RequestBody EmployeeRequest request){
        return employeeService.addEmployees(request);
    }
}
