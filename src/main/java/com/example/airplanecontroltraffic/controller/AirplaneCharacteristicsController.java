package com.example.airplanecontroltraffic.controller;

import com.example.airplanecontroltraffic.dto.mapper.AirplaneCharacteristicsMapper;
import com.example.airplanecontroltraffic.dto.request.AirplaneCharacteristicsRequestDto;
import com.example.airplanecontroltraffic.dto.response.AirplaneCharacteristicsResponseDto;
import com.example.airplanecontroltraffic.service.AirplaneCharacteristicsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/airplaneCharacteristic")
public class AirplaneCharacteristicsController {
    private final AirplaneCharacteristicsService characteristicsService;
    private final AirplaneCharacteristicsMapper characteristicsMapper;

    @GetMapping("/all")
    public List<AirplaneCharacteristicsResponseDto> findAll() {
        return characteristicsService.findAll()
                .stream()
                .map(characteristicsMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/add")
    public AirplaneCharacteristicsResponseDto save(@RequestBody AirplaneCharacteristicsRequestDto requestDto) {
        return characteristicsMapper.toDto(characteristicsService
                .save(characteristicsMapper.toModel(requestDto)));
    }
}
