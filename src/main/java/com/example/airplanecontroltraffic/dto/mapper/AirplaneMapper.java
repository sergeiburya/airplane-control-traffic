package com.example.airplanecontroltraffic.dto.mapper;

import java.util.stream.Collectors;
import com.example.airplanecontroltraffic.dto.response.AirplaneResponseDto;
import com.example.airplanecontroltraffic.model.Airplane;
import com.example.airplanecontroltraffic.model.Flight;
import org.springframework.stereotype.Component;

@Component
public class AirplaneMapper {
    public AirplaneResponseDto toDto(Airplane airplane) {
        AirplaneResponseDto airplaneResponseDto = new AirplaneResponseDto();
        airplaneResponseDto.setId(airplane.getId());
        airplaneResponseDto.setFlightsIds(airplane.getFlights()
                .stream()
                .map(Flight::getId)
                .collect(Collectors.toList()));
        airplaneResponseDto.setCharacteristicsIds(airplaneResponseDto.getCharacteristicsIds());
        airplaneResponseDto.setPositionId(airplaneResponseDto.getPositionId());
        return airplaneResponseDto;
    }
}
