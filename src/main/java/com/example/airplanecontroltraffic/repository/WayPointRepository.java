package com.example.airplanecontroltraffic.repository;

import com.example.airplanecontroltraffic.model.WayPoint;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WayPointRepository extends MongoRepository<WayPoint, String> {
    WayPoint findWayPointByPointName(String pointName);
}
