package br.com.fiap.irrigationapi.model;

import java.time.LocalDateTime;

public class Weather {

    private final Long _id;
    public Long getId() { return _id; }

    private final LocalDateTime _time;
    public LocalDateTime getTime() { return _time; }

    private final Integer _temperature;
    public Integer getTemperature() { return _temperature; }

    private final Integer _humidity;
    public Integer getHumidity() { return _humidity; }

    private final String _description;
    public String getDescription() { return _description; }


    public Weather(Long id, LocalDateTime time, Integer temperature, Integer humidity, String description) {
        this._id = id;
        this._time = time;
        this._temperature = temperature;
        this._humidity = humidity;
        this._description = description;
    }

}