package com.example.demo.repository;

import com.example.demo.entity.CovidEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CovidRepository extends JpaRepository<CovidEntity, Integer> {

}
