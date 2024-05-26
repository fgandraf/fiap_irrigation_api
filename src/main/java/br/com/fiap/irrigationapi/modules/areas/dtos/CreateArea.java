package br.com.fiap.irrigationapi.modules.areas.dtos;

import br.com.fiap.irrigationapi.modules.areas.models.Area;
import br.com.fiap.irrigationapi.modules.sensors.models.Sensor;

import java.util.List;

public record CreateArea(
        String description,
        String location,
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
