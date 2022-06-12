package com.example.demo.service;

import com.example.demo.entity.DepartmentEntity;
import com.example.demo.model.request.DepartmentRequest;
import com.example.demo.repository.dao.DepartmentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    @Autowired
    DepartmentDao departmentDao;

    public DepartmentEntity findById(Integer id){
        return departmentDao.findById(id);
    }

    public DepartmentEntity addDepartment(DepartmentRequest department){
//        DepartmentEntity departmentEntity = new DepartmentEntity();
//        departmentEntity.setId();
//        departmentEntity.setName(department.getName());
//        departmentEntity.setDescription(department.getDescription());
//        departmentDao.save(departmentEntity);
        return departmentDao.save(department);
    }
}
