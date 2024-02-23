package com.example.airplanecontroltraffic.controller.rest;

import com.example.airplanecontroltraffic.dto.mapper.AirplaneMapper;
import com.example.airplanecontroltraffic.dto.request.AirplaneRequestDto;
import com.example.airplanecontroltraffic.dto.response.AirplaneResponseDto;
import com.example.airplanecontroltraffic.service.AirplaneService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/airplane")
public class AirplaneRestController {
    private final AirplaneService airplaneService;
    private final AirplaneMapper airplaneMapper;

    @GetMapping("/all")
    public List<AirplaneResponseDto> getAll() {
        return airplaneService.findAll()
                .stream()
                .map(airplaneMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/add")
    public AirplaneResponseDto save(@RequestBody AirplaneRequestDto airplaneRequestDto) {
        return airplaneMapper.toDto(airplaneService.save(
                airplaneMapper.toModel(airplaneRequestDto)));
    }

    @PutMapping("/updatePosition/{id}")
    public AirplaneResponseDto updateAirplanePositionInFly(@PathVariable String id) {
        return airplaneMapper.toDto(airplaneService.updateAirplanePositionInFly(id));
    }
}
