package com.example.airplanecontroltraffic.service;

import com.example.airplanecontroltraffic.model.TemporaryPoint;
import java.util.List;

public interface TemporaryPointService {
    TemporaryPoint save(TemporaryPoint temporaryPoint);

    TemporaryPoint findById(String id);

    List<TemporaryPoint> findAll();

    void deleteById(String id);
}
