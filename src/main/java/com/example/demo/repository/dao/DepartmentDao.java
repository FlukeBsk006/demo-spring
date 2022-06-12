package com.example.demo.repository.dao;

import com.example.demo.entity.DepartmentEntity;
import com.example.demo.model.request.DepartmentRequest;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class DepartmentDao {

    @PersistenceContext
    private EntityManager entityManager;
//
    public DepartmentEntity findById(@PathVariable int id){
        return entityManager.find(DepartmentEntity.class, id);
    }

/*
    public Empdeparment getDeparment (Integer id){

        Query query = entityManager
                .createNativeQuery("select id,fistname,lastname,'IT' as deparment from EMPLOPYEE  WHERE id=:ID", Empdeparment.class);
        query.setParameter("ID",id);

        List<Empdeparment> results  = query.getResultList();
        if (!results.isEmpty()){
            return results.get(0);
        }
        return  null;

    }*/

    @Transactional
    public DepartmentEntity save(DepartmentRequest department){
        DepartmentEntity departmentEntity = new DepartmentEntity();
        departmentEntity.setName(department.getName());
        departmentEntity.setDescription(department.getDescription());
        entityManager.persist(departmentEntity);
        return departmentEntity;
    }

}
