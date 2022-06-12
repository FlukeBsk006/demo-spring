package com.example.demo.model.request;

import lombok.Data;

@Data
public class EmployeeRequest {
    private String email;
    private String name;
    private String phone;
    private Integer department;
    private Integer role;
}
