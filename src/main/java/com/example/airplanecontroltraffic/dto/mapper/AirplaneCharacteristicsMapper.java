package com.example.airplanecontroltraffic.dto.mapper;

import com.example.airplanecontroltraffic.dto.request.AirplaneCharacteristicsRequestDto;
import com.example.airplanecontroltraffic.dto.response.AirplaneCharacteristicsResponseDto;
import com.example.airplanecontroltraffic.model.AirplaneCharacteristics;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AirplaneCharacteristicsMapper {
    private final ModelMapper modelMapper;

    @Autowired
    public AirplaneCharacteristicsMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public AirplaneCharacteristicsResponseDto toDto(AirplaneCharacteristics characteristics) {
        return modelMapper.map(characteristics, AirplaneCharacteristicsResponseDto.class);
    }

    public AirplaneCharacteristics toModel(
            AirplaneCharacteristicsRequestDto characteristicsRequestDto) {
        return modelMapper.map(characteristicsRequestDto, AirplaneCharacteristics.class);
    }
}
