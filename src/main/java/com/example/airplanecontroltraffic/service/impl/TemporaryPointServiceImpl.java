package com.example.airplanecontroltraffic.service.impl;

import java.util.List;
import java.util.Optional;

import com.example.airplanecontroltraffic.model.TemporaryPoint;
import com.example.airplanecontroltraffic.repository.TemporaryPointRepository;
import com.example.airplanecontroltraffic.service.TemporaryPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TemporaryPointServiceImpl implements TemporaryPointService {
    private final TemporaryPointRepository temporaryPointRepository;

    @Autowired
    public TemporaryPointServiceImpl(TemporaryPointRepository temporaryPointRepository) {
        this.temporaryPointRepository = temporaryPointRepository;
    }

    @Override
    public TemporaryPoint save(TemporaryPoint temporaryPoint) {
        return temporaryPointRepository.save(temporaryPoint);
    }

    @Override
    public Optional<TemporaryPoint> findById(String id) {
        return temporaryPointRepository.findById(id);
    }

    @Override
    public List<TemporaryPoint> findAll() {
        return temporaryPointRepository.findAll();
    }

    @Override
    public void deleteById(String id) {
        temporaryPointRepository.deleteById(id);
    }
}
