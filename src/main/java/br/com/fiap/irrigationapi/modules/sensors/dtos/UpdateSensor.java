package br.com.fiap.irrigationapi.modules.sensors.dtos;

import br.com.fiap.irrigationapi.modules.notifications.Notification;
import br.com.fiap.irrigationapi.modules.weathers.models.Weather;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record UpdateSensor(

        @NotBlank(message = "ID is required!")
        Long id,

        @NotBlank(message = "Type is required!")
        String type,

        @NotBlank(message = "Location is required!")
        String location,

        @NotNull(message = "AreaId is required!")
        Long areaId,

        List<Weather> weathers,

        List<Notification> notifications
) {

}
