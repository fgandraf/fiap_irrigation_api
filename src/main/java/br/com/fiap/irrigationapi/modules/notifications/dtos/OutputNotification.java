package br.com.fiap.irrigationapi.modules.notifications.dtos;

import br.com.fiap.irrigationapi.modules.notifications.models.Notification;

import java.time.LocalDateTime;

public class OutputNotification {

    private Long id;
    private String description;
    private LocalDateTime timestamp;

    public OutputNotification(Notification notification) {
        this.id = notification.getId();
        this.description = notification.getDescription();
        this.timestamp = notification.getTimestamp();
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}