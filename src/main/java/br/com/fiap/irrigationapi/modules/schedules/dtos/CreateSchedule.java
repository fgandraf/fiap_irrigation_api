package br.com.fiap.irrigationapi.modules.schedules.dtos;

import java.time.LocalDateTime;

public record CreateSchedule(
        LocalDateTime startTime,
        LocalDateTime endTime
) {
}
