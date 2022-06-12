package com.example.demo.controller;

import com.example.demo.entity.CovidEntity;
import com.example.demo.model.response.CovidCheck;
import com.example.demo.repository.CovidRepository;
import com.example.demo.repository.dao.MemberDao;
import com.example.demo.service.CovidCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class CovidCheckController {

    @Autowired
    public CovidCheckService covidCheckService;

    @Autowired
    public CovidRepository covidRepository;

    @Autowired
    public MemberDao memberDao;

    @GetMapping(value = "/")
    public List<CovidCheck> check(){
        return covidCheckService.findAll();
    }

    @GetMapping(value = "/findAll")
    public List<CovidEntity> findAll(){
        List<CovidEntity> res = covidRepository.findAll();
        return res;
    }
    @GetMapping(value = "/insert")
    public ResponseEntity<String> insert(){
        covidCheckService.save();
        return new ResponseEntity("OK", HttpStatus.OK);
    }

    @GetMapping(value = "/jdbc-all")
    public CovidCheck jdbcMemberAll(){
        return memberDao.getCovidCheck();
    }
//    public List<CovidCheck> getTxn_date() {
//        return new CovidCheckController().check();
//    }

}
