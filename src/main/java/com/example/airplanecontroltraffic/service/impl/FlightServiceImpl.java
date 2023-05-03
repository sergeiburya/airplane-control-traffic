package com.example.airplanecontroltraffic.service.impl;

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
        List<WayPoint> wayPoints = flight.getWayPoints();
        if (wayPoints != null) {
            for (WayPoint wayPoint : wayPoints) {
                if (wayPoint.getId() == null) {
                    wayPointService.create(wayPoint);
                }
            }
        }
        List<TemporaryPoint> passedPoints = flight.getPassedPoints();
        if (passedPoints != null) {
            for (TemporaryPoint passedPoint : passedPoints) {
                if (passedPoint.getId() == null) {
                    temporaryPointService.save(passedPoint);
                }
            }
        }
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
