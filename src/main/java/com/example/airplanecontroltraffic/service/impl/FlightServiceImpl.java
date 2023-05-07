package com.example.airplanecontroltraffic.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.example.airplanecontroltraffic.model.Flight;
import com.example.airplanecontroltraffic.model.TemporaryPoint;
import com.example.airplanecontroltraffic.model.WayPoint;
import com.example.airplanecontroltraffic.repository.FlightRepository;
import com.example.airplanecontroltraffic.service.FlightService;
import com.example.airplanecontroltraffic.service.TemporaryPointService;
import com.example.airplanecontroltraffic.service.WayPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightServiceImpl implements FlightService {
    private final FlightRepository flightRepository;
    private final WayPointService wayPointService;
    private final TemporaryPointService temporaryPointService;

    @Autowired
    public FlightServiceImpl(FlightRepository flightRepository,
                             WayPointService wayPointService,
                             TemporaryPointService temporaryPointService) {
        this.flightRepository = flightRepository;
        this.wayPointService = wayPointService;
        this.temporaryPointService = temporaryPointService;
    }

    @Override
    public Flight save(Flight flight) {
        List<WayPoint> inWayPoints = flight.getWayPoints();
        List<WayPoint> outWayPoints = new ArrayList<>();
        if (inWayPoints != null) {
            for (WayPoint wayPoint : inWayPoints) {
                if (wayPoint.getId() != null) {
                    outWayPoints.add(wayPointService.findById(wayPoint.getId()));
                } else if (wayPoint.getPointName() != null) {
                    outWayPoints.add(wayPointService.findWayPointByPointName(wayPoint.getPointName()));
                } else {
                    wayPointService.create(wayPoint);
                    outWayPoints.add(wayPoint);
                }
            }
        }
        flight.setWayPoints(outWayPoints);
        List<TemporaryPoint> inPassedPoints = flight.getPassedPoints();
        List<TemporaryPoint> outPassedPoints = new ArrayList<>();
        if (inPassedPoints != null) {
            for (TemporaryPoint passedPoint : inPassedPoints) {
                if (passedPoint.getId() != null) {
                    outPassedPoints.add(temporaryPointService.findById(passedPoint.getId()));
                } else {
                    outPassedPoints.add(temporaryPointService.save(passedPoint));
                }
            }
        }
        flight.setPassedPoints(outPassedPoints);
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
