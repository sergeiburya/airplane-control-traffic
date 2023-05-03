package com.example.airplanecontroltraffic.dto.mapper;

import com.example.airplanecontroltraffic.dto.request.FlightRequestDto;
import com.example.airplanecontroltraffic.dto.response.FlightResponseDto;
import com.example.airplanecontroltraffic.model.Flight;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FlightMapper {
    private final ModelMapper modelMapper;

    @Autowired
    public FlightMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public FlightResponseDto toDto(Flight flight) {
        return modelMapper.map(flight, FlightResponseDto.class);
    }

    public Flight toModel (FlightRequestDto flightRequestDto) {
        return modelMapper.map(flightRequestDto, Flight.class);
    }
}
