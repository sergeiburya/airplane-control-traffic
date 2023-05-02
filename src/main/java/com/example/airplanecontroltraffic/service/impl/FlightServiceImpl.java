package com.example.airplanecontroltraffic.service.impl;

import java.util.List;
import java.util.Optional;

import com.example.airplanecontroltraffic.model.Flight;
import com.example.airplanecontroltraffic.repository.FlightRepository;
import com.example.airplanecontroltraffic.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightServiceImpl implements FlightService {
    private final FlightRepository flightRepository;

    @Autowired
    public FlightServiceImpl(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public Flight save(Flight flight) {
        return flightRepository.save(flight);
    }

    @Override
    public Optional<Flight> findById(String id) {
        return flightRepository.findById(id);
    }

    @Override
    public List<Flight> findAll() {
        return flightRepository.findAll();
    }

    @Override
    public void deleteById(String id) {
        flightRepository.deleteById(id);
    }
}
