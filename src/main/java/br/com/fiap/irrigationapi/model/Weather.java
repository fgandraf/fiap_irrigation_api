package br.com.fiap.irrigationapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "tbl_weather")
@Getter
@Setter
public class Weather {

    @Id
    @Column(name = "weather_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_WEATHER")
    @SequenceGenerator(name = "SEQ_WEATHER", sequenceName = "SEQ_WEATHER", allocationSize = 1)
    private Long id;

    private LocalDateTime timestamp;

    private Integer temperature;

    private Integer humidity;

    private String description;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weather weather = (Weather) o;
        return Objects.equals(id, weather.id) && Objects.equals(timestamp, weather.timestamp) && Objects.equals(temperature, weather.temperature) && Objects.equals(humidity, weather.humidity) && Objects.equals(description, weather.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, timestamp, temperature, humidity, description);
    }
}