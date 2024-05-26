package br.com.fiap.irrigationapi.modules.areas.dtos;

import br.com.fiap.irrigationapi.modules.areas.models.Area;
import br.com.fiap.irrigationapi.modules.sensors.models.Sensor;
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

    public UpdateArea(Area area) {
        this(
                area.getId(),
                area.getDescription(),
                area.getLocation(),
                area.getSize(),
                area.getSensor()
        );
    }

}