package br.com.fiap.irrigationapi.modules.sensors.dtos;

import br.com.fiap.irrigationapi.modules.areas.models.Area;
import br.com.fiap.irrigationapi.modules.notifications.models.Notification;
import br.com.fiap.irrigationapi.modules.sensors.models.Sensor;
import br.com.fiap.irrigationapi.modules.weathers.models.Weather;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record CreateSensor(
        @NotBlank(message = "Type is required!")
        String type,
        @NotBlank(message = "Location is required!")
        String location,
        @NotNull(message = "Area is required!")
        Area area,
        List<Weather> weathers,
        List<Notification> notifications
) {

    public CreateSensor(Sensor sensor){
        this(
            sensor.getType(),
            sensor.getLocation(),
            sensor.getArea(),
            sensor.getWeathers(),
            sensor.getNotifications()
        );
    }

}
