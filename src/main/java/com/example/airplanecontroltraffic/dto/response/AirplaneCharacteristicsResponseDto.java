package com.example.airplanecontroltraffic.dto.response;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class AirplaneCharacteristicsResponseDto {
    private String id;
    private String name;
    private double maxSpeed;
    private double acceleration;
    private double speedOfChangeAltitude;
    private double speedOfChangeCourse;
}
