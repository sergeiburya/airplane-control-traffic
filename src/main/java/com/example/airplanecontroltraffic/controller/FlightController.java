package com.example.airplanecontroltraffic.controller;

import java.util.List;
import java.util.stream.Collectors;
import com.example.airplanecontroltraffic.dto.mapper.FlightMapper;
import com.example.airplanecontroltraffic.dto.request.FlightRequestDto;
import com.example.airplanecontroltraffic.dto.response.FlightResponseDto;
import com.example.airplanecontroltraffic.service.FlightService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/flight")
public class FlightController {
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
