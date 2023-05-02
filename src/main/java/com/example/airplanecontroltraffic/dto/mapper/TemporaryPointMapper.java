package com.example.airplanecontroltraffic.dto.mapper;

import com.example.airplanecontroltraffic.dto.request.TemporaryPointRequestDto;
import com.example.airplanecontroltraffic.dto.response.TemporaryPointResponseDto;
import com.example.airplanecontroltraffic.model.TemporaryPoint;
import org.springframework.stereotype.Component;

@Component
public class TemporaryPointMapper {
    public TemporaryPointResponseDto toDto(TemporaryPoint temporaryPoint) {
        TemporaryPointResponseDto responseDto = new TemporaryPointResponseDto();
        responseDto.setId(temporaryPoint.getId());
        responseDto.setLongitude(temporaryPoint.getLongitude());
        responseDto.setLatitude(temporaryPoint.getLatitude());
        responseDto.setFlightSpeed(temporaryPoint.getFlightSpeed());
        responseDto.setFlightHeight(temporaryPoint.getFlightHeight());
        responseDto.setAzimuth(temporaryPoint.getAzimuth());
        return responseDto;
    }

    public TemporaryPoint toModel(TemporaryPointRequestDto requestDto) {
        TemporaryPoint temporaryPoint = new TemporaryPoint();
        temporaryPoint.setLongitude(requestDto.getLongitude());
        temporaryPoint.setLatitude(requestDto.getLatitude());
        temporaryPoint.setFlightSpeed(requestDto.getFlightSpeed());
        temporaryPoint.setFlightHeight(requestDto.getFlightHeight());
        temporaryPoint.setAzimuth(requestDto.getAzimuth());
        return temporaryPoint;
    }
}
