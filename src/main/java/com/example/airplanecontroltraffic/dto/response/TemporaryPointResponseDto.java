package com.example.airplanecontroltraffic.dto.response;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class TemporaryPointResponseDto {
    private String id;
    private double latitude;
    private double longitude;
    private double flightHeight;
    private double flightSpeed;
    private double azimuth;
}
