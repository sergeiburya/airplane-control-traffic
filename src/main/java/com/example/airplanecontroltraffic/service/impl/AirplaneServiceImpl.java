package com.example.airplanecontroltraffic.service.impl;

import java.util.List;
import java.util.Optional;

import com.example.airplanecontroltraffic.model.Airplane;
import com.example.airplanecontroltraffic.repository.AirplaneRepository;
import com.example.airplanecontroltraffic.service.AirplaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirplaneServiceImpl implements AirplaneService {
    private final AirplaneRepository airplaneRepository;

    @Autowired
    public AirplaneServiceImpl(AirplaneRepository airplaneRepository) {
        this.airplaneRepository = airplaneRepository;
    }

    @Override
    public Airplane save(Airplane airplane) {
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
