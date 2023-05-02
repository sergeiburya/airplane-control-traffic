package com.example.airplanecontroltraffic.service;

import java.util.List;
import java.util.Optional;

import com.example.airplanecontroltraffic.model.Flight;

public interface FlightService {
    Flight save(Flight flight);
    Optional<Flight> findById(String id);

    List<Flight> findAll();

    void deleteById(String id);
}
