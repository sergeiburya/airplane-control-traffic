package com.example.airplanecontroltraffic.controller;

import com.example.airplanecontroltraffic.dto.mapper.WayPointMapper;
import com.example.airplanecontroltraffic.dto.request.WayPointRequestDto;
import com.example.airplanecontroltraffic.dto.response.WayPointResponseDto;
import com.example.airplanecontroltraffic.service.WayPointService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("way-point")
public class WayPointController {
    private final WayPointMapper wayPointMapper;
    private final WayPointService wayPointService;

    @GetMapping("/way-points")
    public String getAllWayPoints(Model model) {
        List<WayPointResponseDto> wayPoints = wayPointService.findAll()
                .stream()
                .map(wayPointMapper::toDto)
                .collect(Collectors.toList());
        model.addAttribute("title", "Way Points");
        model.addAttribute("name", "Way Points");
        model.addAttribute("wayPoints", wayPoints);
        return "way-points";
    }

    @GetMapping("/add")
    public String showNewWayPoint(Model model) {
        model.addAttribute("title", "Add Way Point");
        model.addAttribute("name", "Add New Way Point");
        return "way-point-add";
    }

    @PostMapping("/add")
    public String saveNewWayPoint(
            @ModelAttribute WayPointRequestDto wayPointRequestDto, Model model) {
        WayPointResponseDto dto =
                wayPointMapper.toDto(
                        wayPointService.create(wayPointMapper.toModel(wayPointRequestDto)));
        model.addAttribute("title", "Add Way Point");
        model.addAttribute("name", "Add New Way Point");
        model.addAttribute("wayPoint", dto);
        return "redirect:/way-point/add";
    }
}
