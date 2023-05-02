package com.example.airplanecontroltraffic.service;

import java.util.List;
import java.util.Optional;

import com.example.airplanecontroltraffic.model.AirplaneCharacteristics;

public interface AirplaneCharacteristicsService {
    AirplaneCharacteristics save(AirplaneCharacteristics airplaneCharacteristics);

    Optional<AirplaneCharacteristics> findById(String id);

    List<AirplaneCharacteristics> findAll();

    void deleteById(String id);
}
