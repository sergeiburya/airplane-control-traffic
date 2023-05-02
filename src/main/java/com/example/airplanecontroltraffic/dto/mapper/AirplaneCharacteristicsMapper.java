package com.example.airplanecontroltraffic.dto.mapper;

import com.example.airplanecontroltraffic.dto.request.AirplaneCharacteristicsRequestDto;
import com.example.airplanecontroltraffic.dto.response.AirplaneCharacteristicsResponseDto;
import com.example.airplanecontroltraffic.model.AirplaneCharacteristics;
import org.springframework.stereotype.Component;

@Component
public class AirplaneCharacteristicsMapper {
    public AirplaneCharacteristicsResponseDto toDto(AirplaneCharacteristics characteristics) {
        AirplaneCharacteristicsResponseDto characteristicsResponseDto =
                new AirplaneCharacteristicsResponseDto();
        characteristicsResponseDto.setId(characteristics.getId());
        characteristicsResponseDto.setAcceleration(characteristics.getAcceleration());
        characteristicsResponseDto.setMaxSpeed(characteristics.getMaxSpeed());
        characteristicsResponseDto.setSpeedOfChangeAltitude(characteristics.getSpeedOfChangeAltitude());
        characteristicsResponseDto.setSpeedOfChangeCourse(characteristics.getSpeedOfChangeCourse());
        return characteristicsResponseDto;
    }

    public AirplaneCharacteristics toModel(AirplaneCharacteristicsRequestDto characteristicsRequestDto) {
        AirplaneCharacteristics airplaneCharacteristics = new AirplaneCharacteristics();
        airplaneCharacteristics.setMaxSpeed(characteristicsRequestDto.getMaxSpeed());
        airplaneCharacteristics.setAcceleration(characteristicsRequestDto.getAcceleration());
        airplaneCharacteristics.setSpeedOfChangeCourse(characteristicsRequestDto.getSpeedOfChangeCourse());
        airplaneCharacteristics.setSpeedOfChangeAltitude(characteristicsRequestDto.getSpeedOfChangeAltitude());
        return airplaneCharacteristics;
    }
}
