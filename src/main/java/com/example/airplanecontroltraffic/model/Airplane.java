package com.example.airplanecontroltraffic.model;

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
@Document("airplanes")
public class Airplane {
    @Id
    private String id;
    @DBRef
    private AirplaneCharacteristics characteristics;
    @DBRef
    private TemporaryPoint position;
    @DBRef
    private Flight flight;
}
