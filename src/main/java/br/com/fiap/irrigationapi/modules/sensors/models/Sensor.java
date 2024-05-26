package br.com.fiap.irrigationapi.modules.sensors.models;

import br.com.fiap.irrigationapi.modules.weathers.models.Weather;
import br.com.fiap.irrigationapi.modules.areas.models.Area;
import br.com.fiap.irrigationapi.modules.notifications.models.Notification;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Table(name = "tbl_sensor")
@Getter
@Setter
@EqualsAndHashCode
public class Sensor {

    @Id
    @Column(name = "sensor_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SENSOR")
    @SequenceGenerator(name = "SEQ_SENSOR", sequenceName = "SEQ_SENSOR", allocationSize = 1)
    private Long id;

    private String type;

    private String location;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "area_id")
    private Area area;

    @OneToMany(mappedBy = "sensor")
    private List<Weather> weathers;

    @OneToMany(mappedBy = "sensor")
    private List<Notification> notifications;
}