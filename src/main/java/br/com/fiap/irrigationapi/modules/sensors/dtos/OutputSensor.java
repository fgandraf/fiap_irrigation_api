package br.com.fiap.irrigationapi.modules.sensors.dtos;

import br.com.fiap.irrigationapi.modules.notifications.Notification;
import br.com.fiap.irrigationapi.modules.sensors.Sensor;
import br.com.fiap.irrigationapi.modules.weathers.Weather;

import java.util.List;

public record OutputSensor(
        Long id,
        String type,
        String location,
        Long areaId,
        List<Weather> weathers,
        List<Notification> notifications
) {

    public OutputSensor(Sensor sensor){
        this(
            sensor.getId(),
            sensor.getType(),
            sensor.getLocation(),
            sensor.getArea().getId(),
            sensor.getWeathers(),
            sensor.getNotifications()
        );
    }

}
