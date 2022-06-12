package com.example.demo.model.response;

import lombok.Data;

@Data
public class CovidCheck {
    public String txn_date;
    private String province;
    private int new_case;
    private int total_case;
    private int new_case_excludeabroad;
    private int total_case_excludeabroad;
    private int new_death;
    private int total_death;
    private String update_date;

    public CovidCheck(String txn_date) {
        this.txn_date = txn_date;
    }

    public CovidCheck(){

    }

}

