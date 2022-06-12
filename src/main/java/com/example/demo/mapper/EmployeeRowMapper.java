package com.example.demo.mapper;

import com.example.demo.entity.DepartmentEntity;
import com.example.demo.entity.EmployeeEntity;
import com.example.demo.model.response.EmployeeGetAllResponse;
import com.example.demo.repository.dao.DepartmentDao;
import com.example.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper implements RowMapper<EmployeeGetAllResponse> {

    @Autowired
    DepartmentDao departmentDao;

    @Override
    public EmployeeGetAllResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
        EmployeeGetAllResponse employee = new EmployeeGetAllResponse();
        employee.setId(rs.getInt("id"));
        employee.setEmail(rs.getString("email"));
        employee.setName(rs.getString("name"));
        employee.setPhone(rs.getString("phone"));

        DepartmentEntity departmentEntity = new DepartmentEntity();
        departmentEntity.setId(rs.getInt("dept_id"));
        departmentEntity.setName(rs.getString("dept_name"));
        departmentEntity.setDescription(rs.getString("description"));
        employee.setDepartment(departmentEntity);

        return employee;
    }

}
