package com.example.airplanecontroltraffic.service;

import com.example.airplanecontroltraffic.model.Flight;
import java.util.List;

public interface FlightService {
    Flight save(Flight flight);

    Flight findById(String id);

    List<Flight> findAll();

    void deleteById(String id);

    Flight findByNumber(Long number);
}
