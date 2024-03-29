package com.example.airplanecontroltraffic.controller.rest;

import com.example.airplanecontroltraffic.dto.mapper.TemporaryPointMapper;
import com.example.airplanecontroltraffic.dto.response.TemporaryPointResponseDto;
import com.example.airplanecontroltraffic.service.TemporaryPointService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/temporary-point")
public class TemporaryPointRestController {
    private final TemporaryPointService pointService;
    private final TemporaryPointMapper pointMapper;

    @GetMapping("/all")
    public List<TemporaryPointResponseDto> findAll() {
        return pointService.findAll()
                .stream()
                .map(pointMapper::toDto)
                .collect(Collectors.toList());
    }
}
