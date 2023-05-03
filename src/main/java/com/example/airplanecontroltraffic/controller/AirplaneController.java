package com.example.airplanecontroltraffic.controller;

import com.example.airplanecontroltraffic.dto.mapper.AirplaneMapper;
import com.example.airplanecontroltraffic.dto.request.AirplaneRequestDto;
import com.example.airplanecontroltraffic.dto.response.AirplaneResponseDto;
import com.example.airplanecontroltraffic.service.AirplaneService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
}
