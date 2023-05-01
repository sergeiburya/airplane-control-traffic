package com.example.airplanecontroltraffic.repository;

import com.example.airplanecontroltraffic.model.Flight;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends MongoRepository<Flight, String> {
}
