package br.com.fiap.irrigationapi.modules.areas.dtos;

import br.com.fiap.irrigationapi.modules.sensors.Sensor;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record UpdateArea(
        @NotBlank(message = "ID is required!")
        Long id,
        String description,
        String location,
        String size,
        List<Sensor> sensor
) {
}