package com.example.airplanecontroltraffic.dto.request;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class AirplaneCharacteristicsRequestDto {
    private String id;
    private String name;
    private double maxSpeed;
    private double acceleration;
    private double speedOfChangeAltitude;
    private double speedOfChangeCourse;
}
