package com.example.airplanecontroltraffic.model;

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
@Document("way_points")
public class WayPoint {
    @Id
    private String id;
    private String pointName;
    private double latitude;
    private double longitude;
    private double flightAltitude;
    private double flightSpeed;
}


