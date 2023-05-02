package com.example.airplanecontroltraffic.dto.response;

import java.util.List;
import lombok.Data;import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.stereotype.Component;

@Data
@Component
public class AirplaneResponseDto {
    private String id;
    private String characteristicsIds;
    private String positionId;
    private List<String> flightsIds;
}
