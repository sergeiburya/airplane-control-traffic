package com.example.airplanecontroltraffic.service.impl;

import com.example.airplanecontroltraffic.model.Flight;
import com.example.airplanecontroltraffic.model.TemporaryPoint;
import com.example.airplanecontroltraffic.model.WayPoint;
import com.example.airplanecontroltraffic.repository.FlightRepository;
import com.example.airplanecontroltraffic.service.FlightService;
import com.example.airplanecontroltraffic.service.TemporaryPointService;
import com.example.airplanecontroltraffic.service.WayPointService;
import java.util.ArrayList;
import java.util.List;
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
                    outWayPoints.add(wayPointService
                            .findWayPointByPointName(wayPoint.getPointName()));
                } else {
                    wayPointService.create(wayPoint);
                    outWayPoints.add(wayPoint);
                }
            }
        }
        flight.setWayPoints(outWayPoints);
        List<TemporaryPoint> passedPoints = new ArrayList<>();
        flight.setPassedPoints(passedPoints);
        return flightRepository.save(flight);
    }

    @Override
    public Flight findById(String id) {
        return flightRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Can't find Flight by id" + id));
    }

    @Override
    public List<Flight> findAll() {
        return flightRepository.findAll();
    }

    @Override
    public void deleteById(String id) {
        flightRepository.deleteById(id);
    }

    @Override
    public Flight findByNumber(Long number) {
        return flightRepository.findByNumber(number);
    }

    @Override
    public Flight updatePassedPoints(TemporaryPoint position, Flight flight) {
        TemporaryPoint passedPoint = new TemporaryPoint();
        passedPoint.setLatitude(position.getLatitude());
        passedPoint.setLongitude(position.getLongitude());
        passedPoint.setFlightHeight(position.getFlightHeight());
        passedPoint.setFlightSpeed(position.getFlightSpeed());
        passedPoint.setCourse(position.getCourse());
        passedPoint.setDistanceToTargetPoint(position.getDistanceToTargetPoint());
        passedPoint.setTimeInPoint(position.getTimeInPoint());
        List<TemporaryPoint> passedPoints = flight.getPassedPoints();
        passedPoints.add(temporaryPointService.save(passedPoint));

        return flightRepository.save(flight);
    }
}
