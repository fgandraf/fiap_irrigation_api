package br.com.fiap.irrigationapi.modules.sensors.dtos;

import br.com.fiap.irrigationapi.modules.areas.models.Area;
import br.com.fiap.irrigationapi.modules.notifications.models.Notification;
import br.com.fiap.irrigationapi.modules.sensors.models.Sensor;
import br.com.fiap.irrigationapi.modules.weathers.models.Weather;

import java.util.List;

public record UpdateSensor(
        Long id,
        String type,
        String location,
        Area area,
        List<Weather> weathers,
        List<Notification> notifications
) {

    public UpdateSensor(Sensor sensor){
        this(
                sensor.getId(),
                sensor.getType(),
                sensor.getLocation(),
                sensor.getArea(),
                sensor.getWeathers(),
                sensor.getNotifications()
        );
    }

}
