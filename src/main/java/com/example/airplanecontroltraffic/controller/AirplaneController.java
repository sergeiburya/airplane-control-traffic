package com.example.airplanecontroltraffic.controller;

import java.util.List;
import java.util.stream.Collectors;
import com.example.airplanecontroltraffic.dto.mapper.AirplaneMapper;
import com.example.airplanecontroltraffic.dto.request.AirplaneRequestDto;
import com.example.airplanecontroltraffic.dto.response.AirplaneResponseDto;
import com.example.airplanecontroltraffic.service.AirplaneService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/airplane")
public class AirplaneController {
    private final AirplaneService airplaneService;
    private final AirplaneMapper airplaneMapper;

    @GetMapping("/all")
    public List<AirplaneResponseDto> getAll() {
        return airplaneService.findAll()
                .stream().
                map(airplaneMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/add")
    public AirplaneResponseDto save(@RequestBody AirplaneRequestDto airplaneRequestDto) {
        return airplaneMapper.toDto(airplaneService.save(airplaneMapper.toModel(airplaneRequestDto)));
    }

    @GetMapping
    public List<AirplaneResponseDto> airFly() {
        return airplaneService.toFly()
                .stream()
                .map(airplaneMapper::toDto)
                .collect(Collectors.toList());
    }
}
