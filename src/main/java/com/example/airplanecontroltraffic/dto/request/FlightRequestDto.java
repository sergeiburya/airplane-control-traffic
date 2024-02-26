package com.example.airplanecontroltraffic.dto.request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class FlightRequestDto {
    private String id;
    private Long number;
    @JsonDeserialize(contentAs = WayPointRequestDto.class)
    private List<WayPointRequestDto> wayPoints;
    @JsonDeserialize(contentAs = TemporaryPointRequestDto.class)
    private List<TemporaryPointRequestDto> passedPoints;
}
