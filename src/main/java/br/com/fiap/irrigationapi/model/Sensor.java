package br.com.fiap.irrigationapi.model;

import java.util.ArrayList;
import java.util.List;

public class Sensor {

    private final Long _id;
    public Long getId() { return _id; }

    private String _type;
    public String getType() { return _type; }
    public void setType(String type) { this._type = type; }

    private String _location;
    public String getLocation() { return _location; }
    public void setLocation(String location) { this._location = location; }

    private Area _area;
    public Area getArea() { return _area; }
    public void setArea(Area area) { this._area = area; }

    private final List<Weather> _weather;
    public List<Weather> getWeather() { return _weather; }
    public void setWeather(Weather weather) { _weather.add(weather); }

    private final List<Notification> _notifications;
    public List<Notification> getNotifications() { return _notifications; }
    public void setNotification(Notification notification) { _notifications.add(notification); }

    public Sensor(Long id, String type, String location, Area area){
        this._id = id;
        this._type = type;
        this._location = location;
        this._area = area;
        this._weather = new ArrayList<>();
        this._notifications = new ArrayList<>();
    }

}