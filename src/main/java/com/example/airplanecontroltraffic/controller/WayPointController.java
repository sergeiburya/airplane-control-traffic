package com.example.airplanecontroltraffic.controller;

import com.example.airplanecontroltraffic.dto.request.WayPointRequestDto;
import com.example.airplanecontroltraffic.dto.response.WayPointResponseDto;
import com.example.airplanecontroltraffic.dto.mapper.WayPointMapper;
import com.example.airplanecontroltraffic.service.WayPointService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/way-point")
public class WayPointController {
    private final WayPointService wayPointService;
    private final WayPointMapper wayPointMapper;

    @GetMapping("/all")
    public List<WayPointResponseDto> findAllWayPoints() {
        return wayPointService.findAll()
                .stream()
                .map(wayPointMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public WayPointResponseDto getById(@PathVariable String id) {
        return wayPointMapper.toDto(wayPointService.findById(id));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id) {
        wayPointService.deleteById(id);
    }

    @PostMapping("/add-way-point")
    public WayPointResponseDto save(@RequestBody WayPointRequestDto requestDto) {
        return wayPointMapper.toDto(wayPointService.create(wayPointMapper.toModel(requestDto)));
    }
}
