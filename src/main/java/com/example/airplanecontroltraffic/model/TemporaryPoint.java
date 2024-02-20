package com.example.airplanecontroltraffic.model;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Document("temporary_points")
public class TemporaryPoint {
    @Id
    private String id;
    private double latitude;
    private double longitude;
    private double flightHeight;
    private double flightSpeed;
    private double course;
    private LocalDateTime timeInPoint;
}
