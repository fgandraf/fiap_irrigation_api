package br.com.fiap.irrigationapi.modules.sensors.dtos;

import br.com.fiap.irrigationapi.modules.areas.models.Area;
import br.com.fiap.irrigationapi.modules.notifications.models.Notification;
import br.com.fiap.irrigationapi.modules.sensors.models.Sensor;
import br.com.fiap.irrigationapi.modules.weathers.models.Weather;

import java.util.List;

public record CreateSensor(
        String type,
        String location,
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
