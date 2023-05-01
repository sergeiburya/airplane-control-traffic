package com.example.airplanecontroltraffic.service;

import com.example.airplanecontroltraffic.model.WayPoint;
import java.util.List;
import java.util.Optional;

public interface WayPointService {
    WayPoint create(WayPoint wayPoint);

    Optional<WayPoint> findById(String id);

    void deleteById(String id);

    List<WayPoint> findAll();
}
