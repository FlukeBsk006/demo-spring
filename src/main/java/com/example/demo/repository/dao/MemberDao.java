package com.example.demo.repository.dao;

import com.example.demo.model.response.CovidCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Optional;

@Repository
public class MemberDao {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public CovidCheck getCovidCheck(){
        String sql = "SELECT txn_date FROM covid_entity";
        CovidCheck covidCheck = new CovidCheck();
        Optional<CovidCheck> result = jdbcTemplate.queryForList(sql, CovidCheck .class)
                .stream().findAny();
        covidCheck.setTxn_date(result.get().getTxn_date());

        System.out.println(genSeqence());
        return covidCheck;
    }

    public String genSeqence(){
        String sql = "SELECT nextval('seq_covid');";
        return jdbcTemplate.queryForList(sql, String .class)
                .stream().findFirst().get().toString();
    }
}
