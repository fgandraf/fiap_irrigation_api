package br.com.fiap.irrigationapi.modules.weathers;

import br.com.fiap.irrigationapi.modules.sensors.Sensor;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_weather")
@Getter
@Setter
@EqualsAndHashCode
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

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "sensor_id")
    private Sensor sensor;
}