package com.example.airplanecontroltraffic.dto.request;

import java.util.List;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class FlightRequestDto {
    private Long number;
    private List<String> wayPointIds;
    private List<String> passedPointIds;
}
