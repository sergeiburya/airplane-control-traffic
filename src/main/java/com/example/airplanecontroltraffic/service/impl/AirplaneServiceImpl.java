package com.example.airplanecontroltraffic.service.impl;

import java.util.List;
import java.util.Optional;

import com.example.airplanecontroltraffic.model.Airplane;
import com.example.airplanecontroltraffic.model.AirplaneCharacteristics;
import com.example.airplanecontroltraffic.model.Flight;
import com.example.airplanecontroltraffic.model.TemporaryPoint;
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
}
