package com.example.airplanecontroltraffic.dto.request;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class WayPointRequestDto {
    private String id;
    private String pointName;
    private double latitude;
    private double longitude;
    private double flightHeight;
    private double flightSpeed;
}
