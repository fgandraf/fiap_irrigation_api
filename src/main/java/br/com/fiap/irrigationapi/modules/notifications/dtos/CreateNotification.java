package br.com.fiap.irrigationapi.modules.notifications.dtos;

import java.time.LocalDateTime;

public class CreateNotification {
    private String description;
    private LocalDateTime timestamp;

    // Getters and Setters
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
