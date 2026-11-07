package com.klef.soa.service;

import java.util.List;

import com.klef.soa.entity.Airline;

public interface AirlineService
{
    String addAirline(Airline airline);

    String updateAirline(Airline airline);

    String deleteAirline(long id);

    List<Airline> displayAllAirlines();

    Airline displayById(long id);

    List<Airline> displayByName(String name);

    List<Airline> displayByType(String type);

    long displayAirlineCount();
}