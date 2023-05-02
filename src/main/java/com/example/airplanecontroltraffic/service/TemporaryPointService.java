package com.example.airplanecontroltraffic.service;

import java.util.List;
import java.util.Optional;
import com.example.airplanecontroltraffic.model.TemporaryPoint;

public interface TemporaryPointService {
    TemporaryPoint save(TemporaryPoint temporaryPoint);
    Optional<TemporaryPoint> findById(String id);

    List<TemporaryPoint> findAll();

    void deleteById(String id);
}
