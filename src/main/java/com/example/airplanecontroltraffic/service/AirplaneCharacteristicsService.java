package com.example.airplanecontroltraffic.service;

import com.example.airplanecontroltraffic.model.AirplaneCharacteristics;
import java.util.List;

public interface AirplaneCharacteristicsService {
    AirplaneCharacteristics save(AirplaneCharacteristics airplaneCharacteristics);

    AirplaneCharacteristics findById(String id);

    List<AirplaneCharacteristics> findAll();

    void deleteById(String id);
}
