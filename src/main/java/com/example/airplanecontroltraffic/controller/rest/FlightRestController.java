package com.example.airplanecontroltraffic.controller.rest;

import com.example.airplanecontroltraffic.dto.mapper.FlightMapper;
import com.example.airplanecontroltraffic.dto.request.FlightRequestDto;
import com.example.airplanecontroltraffic.dto.response.FlightResponseDto;
import com.example.airplanecontroltraffic.service.FlightService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/flight")
public class FlightRestController {
    private final FlightService flightService;
    private final FlightMapper flightMapper;

    @GetMapping("/all")
    public List<FlightResponseDto> findAll() {
        return flightService.findAll()
                .stream()
                .map(flightMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/add")
    public FlightResponseDto save(@RequestBody FlightRequestDto flightRequestDto) {
        return flightMapper.toDto(flightService.save(flightMapper.toModel(flightRequestDto)));
    }
}
