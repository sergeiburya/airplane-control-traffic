package com.example.airplanecontroltraffic.controller;

import com.example.airplanecontroltraffic.dto.mapper.AirplaneCharacteristicsMapper;
import com.example.airplanecontroltraffic.dto.request.AirplaneCharacteristicsRequestDto;
import com.example.airplanecontroltraffic.dto.response.AirplaneCharacteristicsResponseDto;
import com.example.airplanecontroltraffic.service.AirplaneCharacteristicsService;
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
@RequestMapping("airplane-characteristic")
public class AirplaneCharacteristicsController {
    private final AirplaneCharacteristicsService characteristicsService;
    private final AirplaneCharacteristicsMapper characteristicsMapper;

    @GetMapping("/all")
    public String getAllCharacteristics(Model model) {
        List<AirplaneCharacteristicsResponseDto> characteristics = characteristicsService.findAll()
                .stream()
                .map(characteristicsMapper::toDto)
                .collect(Collectors.toList());
        model.addAttribute("title", "ACH");
        model.addAttribute("name", "Airplane Characteristics");
        model.addAttribute("characteristics", characteristics);
        return "characteristics";
    }

    @GetMapping("/add")
    public String showNewCharacteristic(Model model) {
        model.addAttribute("title", "Add ACH");
        model.addAttribute("name", "Add New Airplane Characteristics");
        return "add-characteristic";
    }

    @PostMapping("/add")
    public String saveNewCharacteristic(
            @ModelAttribute AirplaneCharacteristicsRequestDto characteristicsRequestDto,
            Model model) {
        AirplaneCharacteristicsResponseDto characteristic =
                characteristicsMapper.toDto(
                        characteristicsService.save(
                                characteristicsMapper.toModel(characteristicsRequestDto)));
        model.addAttribute("title", "Add ACH");
        model.addAttribute("characteristic", characteristic);
        return "redirect:/airplane-characteristic/add";
    }
}
