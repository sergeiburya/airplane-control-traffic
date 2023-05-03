package com.example.airplanecontroltraffic.controller;

import java.util.List;
import java.util.stream.Collectors;
import com.example.airplanecontroltraffic.dto.mapper.TemporaryPointMapper;
import com.example.airplanecontroltraffic.dto.request.TemporaryPointRequestDto;
import com.example.airplanecontroltraffic.dto.response.TemporaryPointResponseDto;
import com.example.airplanecontroltraffic.service.TemporaryPointService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/temporary-point")
public class TemporaryPointController {
    private final TemporaryPointService pointService;
    private final TemporaryPointMapper pointMapper;

    @GetMapping("/all")
    public List<TemporaryPointResponseDto> findAll() {
        return pointService.findAll()
                .stream()
                .map(pointMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/add")
    public TemporaryPointResponseDto save(
            @RequestBody TemporaryPointRequestDto requestDto) {
        return pointMapper.toDto(pointService.save(pointMapper.toModel(requestDto)));
    }
}
