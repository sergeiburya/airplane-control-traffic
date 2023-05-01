package com.example.airplanecontroltraffic.dto.mapper;

import com.example.airplanecontroltraffic.dto.request.WayPointRequestDto;
import com.example.airplanecontroltraffic.dto.response.WayPointResponseDto;
import com.example.airplanecontroltraffic.model.WayPoint;
import org.springframework.stereotype.Component;

@Component
public class WayPointMapper {
    public WayPointResponseDto toDto(WayPoint wayPoint) {
        WayPointResponseDto wayPointResponseDto = new WayPointResponseDto();
        wayPointResponseDto.setId(wayPoint.getId());
        wayPointResponseDto.setPointName(wayPoint.getPointName());
        wayPointResponseDto.setLatitude(wayPoint.getLatitude());
        wayPointResponseDto.setLongitude(wayPoint.getLongitude());
        wayPointResponseDto.setFlightHeight(wayPoint.getFlightHeight());
        wayPointResponseDto.setFlightSpeed(wayPoint.getFlightSpeed());
        return wayPointResponseDto;
    }

    public WayPoint toModel(WayPointRequestDto requestDto) {
        WayPoint wayPoint = new WayPoint();
        wayPoint.setPointName(requestDto.getPointName());
        wayPoint.setLatitude(requestDto.getLatitude());
        wayPoint.setLongitude(requestDto.getLongitude());
        wayPoint.setFlightHeight(requestDto.getFlightHeight());
        wayPoint.setFlightSpeed(requestDto.getFlightSpeed());
        return wayPoint;
    }
}
