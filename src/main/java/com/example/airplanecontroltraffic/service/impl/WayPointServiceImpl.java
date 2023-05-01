package com.example.airplanecontroltraffic.service.impl;

import com.example.airplanecontroltraffic.model.WayPoint;
import com.example.airplanecontroltraffic.service.WayPointService;
import java.util.List;
import java.util.Optional;
import com.example.airplanecontroltraffic.repository.WayPointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WayPointServiceImpl implements WayPointService {
    private final WayPointRepository wayPointRepository;

    @Autowired
    public WayPointServiceImpl(WayPointRepository wayPointRepository) {
        this.wayPointRepository = wayPointRepository;
    }

    @Override
    public WayPoint create(WayPoint wayPoint) {
        return wayPointRepository.insert(wayPoint);
    }

    @Override
    public Optional<WayPoint> findById(String id) {
        return wayPointRepository.findById(id);
    }

    @Override
    public void deleteById(String id) {
        wayPointRepository.deleteById(id);
    }

    @Override
    public List<WayPoint> findAll() {
        return wayPointRepository.findAll();
    }
}
