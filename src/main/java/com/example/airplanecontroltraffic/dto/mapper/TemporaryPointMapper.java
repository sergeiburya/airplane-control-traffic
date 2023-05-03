package com.example.airplanecontroltraffic.dto.mapper;

import com.example.airplanecontroltraffic.dto.request.TemporaryPointRequestDto;
import com.example.airplanecontroltraffic.dto.response.TemporaryPointResponseDto;
import com.example.airplanecontroltraffic.model.TemporaryPoint;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TemporaryPointMapper {
    private final ModelMapper modelMapper;

    @Autowired
    public TemporaryPointMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public TemporaryPointResponseDto toDto(TemporaryPoint temporaryPoint) {
        return modelMapper.map(temporaryPoint, TemporaryPointResponseDto.class);
    }

    public TemporaryPoint toModel(TemporaryPointRequestDto requestDto) {
        return modelMapper.map(requestDto, TemporaryPoint.class);
    }
}
