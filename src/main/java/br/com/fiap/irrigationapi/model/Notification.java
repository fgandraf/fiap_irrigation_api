package br.com.fiap.irrigationapi.model;

import java.time.LocalDateTime;

public class Notification {

    private final Integer _id;
    public Integer getId() { return _id; }

    private final String _description;
    public String getDescription() { return _description; }

    private final LocalDateTime _date;
    public LocalDateTime getDate() { return _date; }

    private final Sensor _sensor;
    public Sensor getSensor() { return _sensor; }

    public Notification(Integer id, String description, LocalDateTime date, Sensor sensor) {
        this._id = id;
        this._description = description;
        this._date = date;
        this._sensor = sensor;
    }

}
