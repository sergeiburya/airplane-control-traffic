package com.example.airplanecontroltraffic.dto.response;

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
public class FlightResponseDto {
    private String id;
    private Long number;
    @JsonDeserialize(contentAs = WayPointResponseDto.class)
    private List<WayPointResponseDto> wayPoints;
    @JsonDeserialize(contentAs = TemporaryPointResponseDto.class)
    private List<TemporaryPointResponseDto> passedPoints;
}
