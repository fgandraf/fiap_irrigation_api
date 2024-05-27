package br.com.fiap.irrigationapi.modules.weathers.dtos;

import br.com.fiap.irrigationapi.modules.weathers.models.Weather;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record OutputWeather(
        Long id,

        LocalDateTime timestamp,

        Integer temperature,

        Integer humidity,

        @NotBlank(message = "Description is required!")
        String description,

        Long sensorId
) {
    public OutputWeather(Weather weather) {
        this(
                weather.getId(),
                weather.getTimestamp(),
                weather.getTemperature(),
                weather.getHumidity(),
                weather.getDescription(),
                weather.getSensor().getId()
        );
    }


}