package com.example.demo.service;

import com.example.demo.model.request.EmployeeRequest;
import com.example.demo.model.response.EmployeeGetAllResponse;
import com.example.demo.repository.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public List<EmployeeGetAllResponse> getAll(){
        return employeeDao.getAll();
    }

    public EmployeeGetAllResponse addEmployees(EmployeeRequest request) {
        return employeeDao.save(request);
    }
}
