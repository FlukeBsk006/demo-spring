package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class CovidEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String txn_date;
    private String province;
    private int new_case;
    private int total_case;
    private int new_case_excludeabroad;
    private int total_case_excludeabroad;
    private int new_death;
    private int total_death;
    private String update_date;
}
