package com.example.airplanecontroltraffic.dto.mapper;

import com.example.airplanecontroltraffic.dto.request.WayPointRequestDto;
import com.example.airplanecontroltraffic.dto.response.WayPointResponseDto;
import com.example.airplanecontroltraffic.model.WayPoint;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WayPointMapper {
    private final ModelMapper modelMapper;

    @Autowired
    public WayPointMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public WayPointResponseDto toDto(WayPoint wayPoint) {
        return modelMapper.map(wayPoint, WayPointResponseDto.class);
    }

    public WayPoint toModel(WayPointRequestDto requestDto) {
        return modelMapper.map(requestDto, WayPoint.class);
    }
}
