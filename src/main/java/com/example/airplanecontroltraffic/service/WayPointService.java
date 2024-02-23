package com.example.airplanecontroltraffic.service;

import com.example.airplanecontroltraffic.model.Flight;
import com.example.airplanecontroltraffic.model.TemporaryPoint;
import com.example.airplanecontroltraffic.model.WayPoint;
import java.util.List;

public interface WayPointService {
    WayPoint create(WayPoint wayPoint);

    WayPoint findById(String id);

    void deleteById(String id);

    List<WayPoint> findAll();

    WayPoint findWayPointByPointName(String pointName);

    WayPoint determineTargetWayPoint(TemporaryPoint position, Flight flight);
}
