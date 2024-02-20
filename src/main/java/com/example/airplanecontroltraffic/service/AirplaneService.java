package com.example.airplanecontroltraffic.service;

import com.example.airplanecontroltraffic.model.Airplane;
import java.util.List;

public interface AirplaneService {
    Airplane save(Airplane airplane);

    Airplane findById(String id);

    List<Airplane> findAll();

    void deleteById(String id);

    List<Airplane> toFly();
}
