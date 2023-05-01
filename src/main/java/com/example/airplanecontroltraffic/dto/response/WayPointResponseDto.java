package com.example.airplanecontroltraffic.dto.response;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class WayPointResponseDto {
    private String id;
    private String pointName;
    private double latitude;
    private double longitude;
    private double flightHeight;
    private double flightSpeed;
}
