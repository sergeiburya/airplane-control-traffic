package com.example.airplanecontroltraffic.repository;

import com.example.airplanecontroltraffic.model.Airplane;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirplaneRepository extends MongoRepository<Airplane, String> {
}
