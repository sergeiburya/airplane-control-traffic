package com.example.airplanecontroltraffic.dto.mapper;

import com.example.airplanecontroltraffic.dto.request.AirplaneRequestDto;
import com.example.airplanecontroltraffic.dto.response.AirplaneResponseDto;
import com.example.airplanecontroltraffic.model.Airplane;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AirplaneMapper {
    private final ModelMapper modelMapper;

    @Autowired
    public AirplaneMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public AirplaneResponseDto toDto(Airplane airplane) {
        return modelMapper.map(airplane, AirplaneResponseDto.class);
    }

    public Airplane toModel(AirplaneRequestDto airplaneRequestDto) {
        return modelMapper.map(airplaneRequestDto, Airplane.class);
    }
}
