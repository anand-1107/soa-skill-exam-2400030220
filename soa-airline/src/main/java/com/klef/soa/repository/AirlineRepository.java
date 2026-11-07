package com.klef.soa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klef.soa.entity.Airline;

public interface AirlineRepository extends JpaRepository<Airline, Long>
{
    List<Airline> findByName(String name);

    List<Airline> findByType(String type);
}