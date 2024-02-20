package com.example.airplanecontroltraffic.service.impl;

import com.example.airplanecontroltraffic.model.AirplaneCharacteristics;
import com.example.airplanecontroltraffic.repository.AirplaneCharacteristicsRepository;
import com.example.airplanecontroltraffic.service.AirplaneCharacteristicsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirplaneCharacteristicsServiceImpl implements AirplaneCharacteristicsService {
    private final AirplaneCharacteristicsRepository repository;

    @Autowired
    public AirplaneCharacteristicsServiceImpl(AirplaneCharacteristicsRepository repository) {
        this.repository = repository;
    }

    @Override
    public AirplaneCharacteristics save(AirplaneCharacteristics airplaneCharacteristics) {
        return repository.save(airplaneCharacteristics);
    }

    @Override
    public AirplaneCharacteristics findById(String id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Can't find AirplaneCharacteristics by id" + id));
    }

    @Override
    public List<AirplaneCharacteristics> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
