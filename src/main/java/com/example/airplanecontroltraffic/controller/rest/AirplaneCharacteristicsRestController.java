package com.example.airplanecontroltraffic.controller.rest;

import com.example.airplanecontroltraffic.dto.mapper.AirplaneCharacteristicsMapper;
import com.example.airplanecontroltraffic.dto.request.AirplaneCharacteristicsRequestDto;
import com.example.airplanecontroltraffic.dto.response.AirplaneCharacteristicsResponseDto;
import com.example.airplanecontroltraffic.service.AirplaneCharacteristicsService;
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
@RequestMapping("/airplaneCharacteristic")
public class AirplaneCharacteristicsRestController {
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
    public AirplaneCharacteristicsResponseDto save(
            @RequestBody AirplaneCharacteristicsRequestDto requestDto) {
        return characteristicsMapper.toDto(characteristicsService
                .save(characteristicsMapper.toModel(requestDto)));
    }
}
