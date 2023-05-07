package com.example.airplanecontroltraffic.service.impl;

import java.util.List;
import java.util.Optional;

import com.example.airplanecontroltraffic.model.*;
import com.example.airplanecontroltraffic.repository.AirplaneRepository;
import com.example.airplanecontroltraffic.service.AirplaneCharacteristicsService;
import com.example.airplanecontroltraffic.service.AirplaneService;
import com.example.airplanecontroltraffic.service.FlightService;
import com.example.airplanecontroltraffic.service.TemporaryPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirplaneServiceImpl implements AirplaneService {
    private final AirplaneRepository airplaneRepository;
    private final AirplaneCharacteristicsService characteristicsService;
    private final FlightService flightService;
    private final TemporaryPointService temporaryPointService;

    @Autowired
    public AirplaneServiceImpl(AirplaneRepository airplaneRepository,
                               AirplaneCharacteristicsService characteristicsService,
                               FlightService flightService,
                               TemporaryPointService temporaryPointService) {
        this.airplaneRepository = airplaneRepository;
        this.characteristicsService = characteristicsService;
        this.flightService = flightService;
        this.temporaryPointService = temporaryPointService;
    }

    @Override
    public Airplane save(Airplane airplane) {
        AirplaneCharacteristics characteristics = airplane.getCharacteristics();
        if (characteristics != null && characteristics.getId() == null) {
            characteristicsService.save(characteristics);
        }
        TemporaryPoint position = airplane.getPosition();
        if (position != null && position.getId() == null) {
            temporaryPointService.save(position);
        }
        List<Flight> flights = airplane.getFlights();
        if (flights != null) {
            for (Flight flight : flights) {
                if (flight.getId() == null) {
                    flightService.save(flight);
                }
            }
        }
        return airplaneRepository.save(airplane);
    }

    @Override
    public Optional<Airplane> findById(String id) {
        return airplaneRepository.findById(id);
    }

    @Override
    public List<Airplane> findAll() {
        return airplaneRepository.findAll();
    }

    @Override
    public void deleteById(String id) {
        airplaneRepository.deleteById(id);
    }

    @Override
    public List<Airplane> toFly() {
        List<Airplane> airplaneList = findAll();
        for (Airplane airplane : airplaneList) {
            List<Flight> flights = airplane.getFlights();
            for (Flight flight : flights) {
                List<WayPoint> wayPoints = flight.getWayPoints();
                for (WayPoint wayPoint : wayPoints) {
                    courseCalculation(airplane.getPosition(), wayPoint);

                }
            }

        }
        return airplaneList;
    }

    private double courseCalculation(TemporaryPoint position, WayPoint wayPoint) {
        double course;
        double currentLatitude = position.getLatitude();
        double currentLongitude = position.getLongitude();
        course = Math.atan2(Math.sin(wayPoint.getLongitude() - currentLongitude)
                    * Math.cos(wayPoint.getLatitude()),
                    Math.cos(currentLatitude)*Math.sin(wayPoint.getLatitude())
                            - Math.sin(currentLatitude) * Math.cos(wayPoint.getLatitude())
                            * Math.cos(wayPoint.getLongitude() - currentLongitude)) * 180/Math.PI;

        return course;
    }
}
