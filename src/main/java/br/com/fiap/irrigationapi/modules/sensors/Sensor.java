package br.com.fiap.irrigationapi.modules.sensors;

import br.com.fiap.irrigationapi.modules.areas.Area;
import br.com.fiap.irrigationapi.modules.notifications.Notification;
import br.com.fiap.irrigationapi.modules.weathers.Weather;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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