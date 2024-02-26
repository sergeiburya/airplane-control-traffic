package com.example.airplanecontroltraffic.controller;

import com.example.airplanecontroltraffic.dto.mapper.FlightMapper;
import com.example.airplanecontroltraffic.dto.request.FlightRequestDto;
import com.example.airplanecontroltraffic.dto.response.FlightResponseDto;
import com.example.airplanecontroltraffic.service.FlightService;
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
@RequestMapping("flight")
public class FlightController {
    private final FlightService flightService;
    private final FlightMapper flightMapper;

    @GetMapping("/all-flights")
    public String getAllFlights(Model model) {
        List<FlightResponseDto> flights = flightService.findAll()
                .stream()
                .map(flightMapper::toDto)
                .collect(Collectors.toList());
        model.addAttribute("title", "Flights");
        model.addAttribute("name", "Flights");
        model.addAttribute("flights", flights);
        return "flights";
    }

    @GetMapping("/add-flight")
    public String showNewFlight(Model model) {
        model.addAttribute("title", "Add Flight");
        model.addAttribute("name", "Add New Flight");
        return "add-flight";
    }

    @PostMapping("/add-flight")
    public String saveNewFlight(
            @ModelAttribute FlightRequestDto flightRequestDto, Model model) {
        FlightResponseDto flight =
                flightMapper.toDto(
                        flightService.save(flightMapper.toModel(flightRequestDto)));
        model.addAttribute("title", "Add Flight");
        model.addAttribute("name", "Add New Flight");
        model.addAttribute("flight", flight);
        return "redirect:/flight/add-flight";
    }
}
