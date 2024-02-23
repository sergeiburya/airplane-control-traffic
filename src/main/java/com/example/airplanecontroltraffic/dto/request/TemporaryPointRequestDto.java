package com.example.airplanecontroltraffic.dto.request;

import java.time.LocalDateTime;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class TemporaryPointRequestDto {
    private String id;
    private double latitude;
    private double longitude;
    private double flightHeight;
    private double flightSpeed;
    private double course;
    private double distanceToTargetPoint;
    private LocalDateTime timeInPoint;
}
