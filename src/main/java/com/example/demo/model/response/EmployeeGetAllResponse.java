package com.example.demo.model.response;

import com.example.demo.entity.DepartmentEntity;
import com.example.demo.entity.RoleEntity;
import lombok.Data;

@Data
public class EmployeeGetAllResponse {
    private Integer id;
    private String email;
    private String name;
    private String phone;
    private DepartmentEntity department;
    private RoleEntity role;
}
