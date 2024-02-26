package com.example.airplanecontroltraffic.repository;

import com.example.airplanecontroltraffic.model.AirplaneCharacteristics;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirplaneCharacteristicsRepository extends
        MongoRepository<AirplaneCharacteristics, String> {
}
