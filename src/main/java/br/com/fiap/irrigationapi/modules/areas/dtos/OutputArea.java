package br.com.fiap.irrigationapi.modules.areas.dtos;

import br.com.fiap.irrigationapi.modules.areas.Area;
import br.com.fiap.irrigationapi.modules.sensors.Sensor;

import java.util.List;

public record OutputArea(
        Long id,
        String description,
        String location,
        String size,
        List<Sensor> sensor
) {

    public OutputArea(Area area) {
        this(
                area.getId(),
                area.getDescription(),
                area.getLocation(),
                area.getSize(),
                area.getSensor()
        );
    }

}
