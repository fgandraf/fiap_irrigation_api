package br.com.fiap.irrigationapi.modules.schedules.dtos;

import java.time.LocalDateTime;

public record UpdateSchedule(
        Long id,
        LocalDateTime startTime,
        LocalDateTime endTime
) {
}
