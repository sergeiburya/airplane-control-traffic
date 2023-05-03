package com.example.airplanecontroltraffic.dto.request;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class AirplaneRequestDto {
    @JsonDeserialize(contentAs = AirplaneCharacteristicsRequestDto.class)
    private AirplaneCharacteristicsRequestDto characteristics;
    @JsonDeserialize(contentAs = TemporaryPointRequestDto.class)
    private TemporaryPointRequestDto position;
    @JsonDeserialize(contentAs = FlightRequestDto.class)
    private List<FlightRequestDto> flights;
}
