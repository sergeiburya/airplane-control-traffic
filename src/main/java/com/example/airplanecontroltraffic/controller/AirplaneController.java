package com.example.airplanecontroltraffic.controller;

import com.example.airplanecontroltraffic.dto.mapper.AirplaneMapper;
import com.example.airplanecontroltraffic.dto.request.AirplaneRequestDto;
import com.example.airplanecontroltraffic.dto.response.AirplaneResponseDto;
import com.example.airplanecontroltraffic.service.AirplaneService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("airplane")
public class AirplaneController {
    private final AirplaneMapper airplaneMapper;
    private final AirplaneService airplaneService;

    @GetMapping("/airplanes")
    public String getAllAirplanes(Model model) {
        List<AirplaneResponseDto> airplanes = airplaneService.findAll()
                .stream()
                .map(airplaneMapper::toDto)
                .collect(Collectors.toList());
        model.addAttribute("title", "Airplanes");
        model.addAttribute("name", "Airplanes");
        model.addAttribute("airplanes", airplanes);
        return "airplanes";
    }

    @GetMapping("/add-airplane")
    public String showNewAirplane(Model model) {
        model.addAttribute("title", "Add Airplane");
        model.addAttribute("name", "Add New Airplane");
        return "add-airplane";
    }

    @PostMapping("/add-airplane")
    public String saveNewAirplane(
            @ModelAttribute AirplaneRequestDto airplaneRequestDto, Model model) {
        AirplaneResponseDto airplane =
                airplaneMapper.toDto(
                        airplaneService.save(airplaneMapper.toModel(airplaneRequestDto)));
        model.addAttribute("title", "Add Airplane");
        model.addAttribute("name", "Add New Airplane");
        model.addAttribute("airplane", airplane);
        return "redirect:/airplane/add-airplane";
    }

    @GetMapping("/updateAirplanePosition")
    public String showAirplanePosition(Model model) {
        model.addAttribute("title", "Update Position");
        model.addAttribute("name", "Update Airplane Position");
        return "redirect:/airplane/updateAirplanePosition";
    }

    @PutMapping("/updateAirplanePosition/{id}")
    public String updateAirplanePosition(@PathVariable String id, Model model) {
        AirplaneResponseDto airplane
                = airplaneMapper.toDto(airplaneService.updateAirplanePositionInFly(id));
        model.addAttribute("title", "Update Position");
        model.addAttribute("name", "Update Airplane Position");
        model.addAttribute("airplane", airplane);
        return "update-airplane-position";
    }
}
