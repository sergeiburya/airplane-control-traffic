package com.example.airplanecontroltraffic.dto.response;

import java.util.List;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class FlightResponseDto {
    private String id;
    private Long number;
    private List<String> wayPointIds;
    private List<String> passedPointIds;
}
