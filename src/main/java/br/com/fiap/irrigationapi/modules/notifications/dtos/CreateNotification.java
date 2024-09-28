package br.com.fiap.irrigationapi.modules.notifications.dtos;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record CreateNotification(
        String description,
        LocalDateTime timestamp,

        @NotNull(message = "SensorId is required!")
        Long sensorId
) {
}
