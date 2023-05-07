package com.example.airplanecontroltraffic.service;

import java.util.List;

import com.example.airplanecontroltraffic.model.TemporaryPoint;

public interface TemporaryPointService {
    TemporaryPoint save(TemporaryPoint temporaryPoint);
    TemporaryPoint findById(String id);

    List<TemporaryPoint> findAll();

    void deleteById(String id);
}
