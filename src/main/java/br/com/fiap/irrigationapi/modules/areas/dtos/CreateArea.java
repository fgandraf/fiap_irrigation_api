package br.com.fiap.irrigationapi.modules.areas.dtos;

import br.com.fiap.irrigationapi.modules.areas.models.Area;
import br.com.fiap.irrigationapi.modules.sensors.models.Sensor;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record CreateArea(
        @NotBlank(message = "Description is required!")
        String description,
        @NotBlank(message = "Location is required!")
        String location,
        @NotBlank(message = "Size is required!")
        String size,
        List<Sensor> sensor
) {

    public CreateArea(Area area) {
        this(
                area.getDescription(),
                area.getLocation(),
                area.getSize(),
                area.getSensor()
        );
    }

}
