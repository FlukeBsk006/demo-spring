package com.example.demo.service;

import com.example.demo.controller.CovidCheckController;
import com.example.demo.entity.CovidEntity;
import com.example.demo.model.response.CovidCheck;
import com.example.demo.repository.CovidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class CovidCheckService {

    @Autowired
    public CovidRepository covidRepository;

    public List<CovidCheck> findAll(){
        RestTemplate restTemplate = new RestTemplate();
        String domain = "https://covid19.ddc.moph.go.th/api/Cases/today-cases-by-provinces";
        CovidCheck[] data = restTemplate.getForObject(domain,CovidCheck[].class);
        List<CovidCheck> responsa = Arrays.asList(data);
        return responsa;
    }

    public void save() {
        List<CovidCheck> res = findAll();
        List<CovidEntity> aa = new ArrayList<CovidEntity>();
        res.forEach(covidCheck -> {
            CovidEntity a = new CovidEntity();
            a.setTxn_date(covidCheck.getTxn_date());
            a.setNew_case(covidCheck.getNew_case());
            a.setProvince(covidCheck.getProvince());
            a.setNew_case_excludeabroad(covidCheck.getNew_case_excludeabroad());
            aa.add(a);
            // covidRepository.save(a);
        });
        covidRepository.saveAll(aa);
    }
}
