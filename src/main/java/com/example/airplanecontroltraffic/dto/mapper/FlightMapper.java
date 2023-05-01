package com.example.airplanecontroltraffic.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;
import com.example.airplanecontroltraffic.dto.request.FlightRequestDto;
import com.example.airplanecontroltraffic.dto.request.WayPointRequestDto;
import com.example.airplanecontroltraffic.dto.response.FlightResponseDto;
import com.example.airplanecontroltraffic.model.Flight;
import com.example.airplanecontroltraffic.model.TemporaryPoint;
import com.example.airplanecontroltraffic.model.WayPoint;
import org.springframework.stereotype.Component;

@Component
public class FlightMapper {
    public FlightResponseDto toDto(Flight flight) {
        FlightResponseDto responseDto = new FlightResponseDto();
        responseDto.setId(flight.getId());
        responseDto.setNumber(flight.getNumber());
        responseDto.setWayPointIds(flight.getWayPoints().stream()
                .map(WayPoint::getId)
                .collect(Collectors.toList()));
        responseDto.setPassedPointIds(flight.getPassedPoints().stream()
                .map(TemporaryPoint::getId)
                .collect(Collectors.toList()));
        return responseDto;
    }

//    public Flight toModel(FlightRequestDto requestDto) {
//        Flight flight = new Flight();
//        flight.setNumber(requestDto.getNumber());
//        List<WayPoint> wayPoints = requestDto.getWayPointIds().stream()
//                .map(wayPointId -> {
//                    WayPoint wayPoint = new WayPoint();
//                    wayPoint.setId(wayPointId);
//                    return wayPoint;
//                })
//                .collect(Collectors.toList());
//        flight.setWayPoints(wayPoints);
//        List<TemporaryPoint> passedPoints = requestDto.getPassedPointIds().stream()
//                .map(passedPointId -> {
//                    TemporaryPoint passedPoint = new TemporaryPoint();
//                    passedPoint.setId(passedPointId);
//                    return passedPoint;
//                })
//                .collect(Collectors.toList());
//        flight.setPassedPoints(passedPoints);
//        return flight;
//    }
}
