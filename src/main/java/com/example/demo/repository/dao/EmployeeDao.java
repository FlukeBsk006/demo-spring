package com.example.demo.repository.dao;

import com.example.demo.entity.DepartmentEntity;
import com.example.demo.entity.EmployeeEntity;
import com.example.demo.mapper.EmployeeRowMapper;
import com.example.demo.model.request.EmployeeRequest;
import com.example.demo.model.response.EmployeeGetAllResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EmployeeDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate nameParamejdbcTemplate;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public EmployeeGetAllResponse save(EmployeeRequest request) {
//        int i = jdbcTemplate.update("INSERT INTO employees(id, name, email, phone, department, role) VALUES(?,?,?,?,?,?)",
        //                          1,
//                                request.getName(),
//                                request.getEmail(),
//                                request.getPhone(),
//                                request.getDepartment(),
//                                request.getRole()
//                            );

        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setName(request.getName());
        employeeEntity.setEmail(request.getEmail());
        employeeEntity.setPhone(request.getPhone());
        employeeEntity.setRole(request.getRole());
        employeeEntity.setDepartment(request.getDepartment());
        entityManager.persist(employeeEntity);
        entityManager.flush();
        int i = employeeEntity.getId();
        return getResponse(i);
    }

    public List<EmployeeGetAllResponse> getAll(){
        String sql = "SELECT a.id, a.name, a.email, a.phone, b.id AS dept_id, b.name AS dept_name, b.description FROM employees  a LEFT JOIN department b ON a.department = b.id";
        List<EmployeeGetAllResponse> employeeEntityList =
                jdbcTemplate.query( sql,new EmployeeRowMapper());
        return employeeEntityList;
    }

    public EmployeeGetAllResponse getResponse(int id){
        String sql = "SELECT a.id, a.name, a.email, a.phone, b.id AS dept_id, b.name AS dept_name, b.description FROM employees  a LEFT JOIN department b ON a.department = b.id WHERE a.id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new EmployeeRowMapper());
    }

    /*
    public EmployeeGetAllResponse getAlls(){
        String sql = "SELECT a.id, a.name, a.email, a.phone, b.id AS dept_id, b.name AS dept_name, b.description FROM employees  a LEFT JOIN department b ON a.department = b.id";
        List<EmployeeGetAllResponse> employeeEntityList =
                jdbcTemplate.query( sql,new EmployeeRowMapper());

        if(employeeEntityList.size()>0){
          return  employeeEntityList.get(0);
        }
        return null;
    }*/


    public String getUser() {

        StringBuilder sql = new StringBuilder("");
        sql.append(" SELECT a.id, a.name, a.phone, b.id AS dept_id, b.name AS dept_name, b.description FROM employees  a LEFT JOIN department b ON a.department = b.id ");
         sql.append(" where u.login = :login ");

        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("","");

        List<EmployeeGetAllResponse> list = nameParamejdbcTemplate.query(sql.toString(), parameters,
                new BeanPropertyRowMapper<EmployeeGetAllResponse>(EmployeeGetAllResponse.class) {
                    @Override
                    public EmployeeGetAllResponse mapRow(ResultSet rs, int rowNumber) throws SQLException {
                        // TODO Auto-generated method stub
                        EmployeeGetAllResponse data = new EmployeeGetAllResponse();
                        DepartmentEntity x = new DepartmentEntity();
                            data.setName(rs.getString("name"));
                             x.setName(rs.getString("description"));

                            data.setDepartment(x);
                        return data;
                    }
                });

        return null;
    }
}
