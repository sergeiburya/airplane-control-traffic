package com.example.airplanecontroltraffic.service;

import java.util.List;
import java.util.Optional;

import com.example.airplanecontroltraffic.model.Airplane;

public interface AirplaneService {
    Airplane save(Airplane airplane);

    Optional<Airplane> findById(String id);

    List<Airplane> findAll();

    void deleteById(String id);

}
