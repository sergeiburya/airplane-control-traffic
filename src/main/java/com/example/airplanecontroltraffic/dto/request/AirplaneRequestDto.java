package com.example.airplanecontroltraffic.dto.request;

import java.util.List;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class AirplaneRequestDto {
    private String characteristicsIds;
    private String positionId;
    private List<String> flightsIds;
}
