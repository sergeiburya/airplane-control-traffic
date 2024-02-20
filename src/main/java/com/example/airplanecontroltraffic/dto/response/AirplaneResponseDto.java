package com.example.airplanecontroltraffic.dto.response;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class AirplaneResponseDto {
    private String id;
    @JsonDeserialize(contentAs = AirplaneCharacteristicsResponseDto.class)
    private AirplaneCharacteristicsResponseDto characteristics;
    @JsonDeserialize(contentAs = TemporaryPointResponseDto.class)
    private TemporaryPointResponseDto position;
    @JsonDeserialize(contentAs = FlightResponseDto.class)
    private FlightResponseDto flight;
}
