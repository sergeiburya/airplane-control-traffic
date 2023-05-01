package com.example.airplanecontroltraffic.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Document("flights")
public class Flight {
    @Id
    private String id;
    private Long number;
    @DBRef
    private List<WayPoint> wayPoints;
    @DBRef
    private List<TemporaryPoint> passedPoints;
}
